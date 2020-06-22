// 235.
//time - O(n logn) - sorting + heap insertion/removal
//space - O(n) - for the heap
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        //edge
        if(intervals == null || intervals.length == 0 || intervals[0].length == 0)
        {
            return 0; //invalid i/p
        }
        
        //sorting array of intervals based on increasing order of start times
        //chronological order of meetings is to check if a meeting overlaps with any previous or subsequent meetings
        Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]); 
        
        //the min heap tracks the number of rooms needed (size of heap) along with the end times of last meetings in each room (actual value)
        PriorityQueue<Integer> rooms = new PriorityQueue<>(); 
        
        for(int[] interval : intervals) 
        {
            //check if current interval overlaps with end time of root of min heap
            if(rooms.isEmpty() || interval[0] < rooms.peek())
            {
                //current meeting starts before the earliest ending meeting (root value of heap)
                //thus it must overlap with all other meetings previously processed (min heap property)
                //new room is needed fr this meeting
                rooms.offer(interval[1]); //so allot a room with endtime equal to that of current meeting
            }
            else
            {
                //the current meeting starts after the meeting in the room tracked by root of heap
                //allot the same room
                rooms.poll();
                rooms.offer(interval[1]);
            }
        }
        
        return rooms.size();
    }
}
