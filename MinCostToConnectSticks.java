// 1167.
//time - O(n logn)
//space - O(n)
class Solution {
    public int connectSticks(int[] sticks) {
        //edge
        if(sticks == null || sticks.length == 0)
        {
            return 0; //empty list
        }
        
        //greedily connect two sticks of smallest length
        //from min heap get two smallest sticks, connect them, add to cost and add the connected stick back to heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int stick : sticks)
        {
            minHeap.offer(stick);
        }
        int cost = 0;
        
        while(minHeap.size() != 1)
        {
            int smallest = minHeap.poll(); 
            int secondSmallest = minHeap.poll(); 
            cost += smallest + secondSmallest;
            minHeap.offer(smallest + secondSmallest); 
        }
        
        return cost;
    }
}
