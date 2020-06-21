// 1090.
class Pair {
    int value;
    int label;
    
    public Pair(int value, int label) {
        this.label = label;
        this.value = value;
    }
}

//time - O(n logn)
//space - O(n)
class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        //brute force - find all subsequences of length num_wanted, validate each sub sequence - time - O(2^n)
        //greedily pick the item with largest value and check if the label constraint is maintained using a map
        
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> b.value - a.value); //max heap of items based on values of items
        for(int i = 0; i < values.length; i++)
        {
            maxHeap.offer(new Pair(values[i], labels[i]));
        }
        
        HashMap<Integer, Integer> labelCounts = new HashMap<>(); //map maintains counts of labels of items picked so far
        int maxValue = 0; //return val
        
        while(maxHeap.size() > 0)
        {
            if(num_wanted == 0)
            {
                break; //cant select more items
            }
            
            Pair item = maxHeap.poll(); //remove the item with largest value
            //if the current item's label is not used as many times as use_limit
            if(!labelCounts.containsKey(item.label) || labelCounts.get(item.label) < use_limit)
            {
                maxValue += item.value; //add the value gained to result
                num_wanted--; //reduce number wanted by 1
                //update the label counts
                if(labelCounts.containsKey(item.label))
                {
                    labelCounts.put(item.label, labelCounts.get(item.label) + 1);
                }
                else
                {
                    labelCounts.put(item.label, 1);
                }
            }
            //else item cant be used
        }
                                
        return maxValue;                       
    }
}
