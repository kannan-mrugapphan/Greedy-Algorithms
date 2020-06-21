// 767.
// time - O(n logn)
// space - O(n)
class Solution {
    public String reorganizeString(String S) {
        //edge
        if(S == null || S.length() == 0)
        {
            return S;
        }
        
        //greedily place the most frequent character followed by the second most frequent character 
        HashMap<Character, Integer> counts = new HashMap<>(); //frequency of characters in s
        for(int i = 0; i < S.length(); i++)
        {
            counts.put(S.charAt(i), counts.getOrDefault(S.charAt(i), 0) + 1);
        }
        
        //max heap tracks the most frequent characters
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> (counts.get(b) - counts.get(a))); 
        for(Character letter : counts.keySet())
        {
            maxHeap.offer(letter);
        }
        
        StringBuilder result = new StringBuilder(); //return string
        
        //as long as there are more than 1 unprocessed characters
        while(maxHeap.size() > 1)
        {
            char current = maxHeap.poll(); //most frequent
            char next = maxHeap.poll(); //second most frequent
            
            //add current and next to result string
            result.append(current);
            result.append(next);
            
            counts.put(current, counts.get(current) - 1); //update the counts 
            counts.put(next, counts.get(next) - 1);
            //if the updated count is above 0, add the char back to max heap else delete the char from counts map
            if(counts.get(current) > 0)
            {
                maxHeap.offer(current);
            }
            else
            {
                maxHeap.remove(current);
            }
            if(counts.get(next) > 0)
            {
                maxHeap.offer(next);
            }
            else
            {
                maxHeap.remove(next);
            }
        }
        
        if(maxHeap.size() == 1) //one more unprocessed char left
        {
            if(counts.get(maxHeap.peek()) > 1) //the unprocessed char has more than 1 freq - so i/p cant be reorganized
            {
                return "";
            }
            else
            {
                result.append(maxHeap.poll());
            }
        }
        
        return result.toString();
    }
}
