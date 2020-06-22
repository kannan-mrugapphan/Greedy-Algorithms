// 763.
// time - O(n)
// space - O(n)
class Solution {
    public List<Integer> partitionLabels(String S) {
        //edge
        if(S == null || S.length() == 0)
        {
            return new ArrayList<>(); //no partitions 
        }
        
        HashMap<Character, Integer> index = new HashMap<>(); //index map tracks the last index at which each char occurs in S
        for(int i = 0; i < S.length(); i++)
        {
            index.put(S.charAt(i), i);
        }
        
        List<Integer> result = new ArrayList<>(); //return list
        int start = 0; //start and end tracks the range of the current possible partiton
        int end = 0;
        
        for(int i = 0; i < S.length(); i++)
        {
            end = Math.max(end, index.get(S.charAt(i))); //update end as a larger index is found
            if(i == end)
            {
                //start to end is a valid partition
                result.add(end - start + 1); //add its size to result
                start = end + 1; //change start to next char
            }
        }
        
        return result;
    }
}
