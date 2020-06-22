// 621.
// greedily shedule the most frequent task
// maxFrequency - task with highest occuernece in tasks[]
// maxCount - # of tasks with same maxFrequency

//eg 1 - 3A2B1C, n = 2
//A _ _ A _ _ A -> 3As with 2 slots in between(since n = 2)
//# of partitions = 3 - 1 = maxFrequency - 1
//# of empty slots = 2 * 2 = n * # of partitions
//# of pending tasks = 2B1C = tasks.length - maxFrequency
//# of idle slots = 4 - 3 = # of empty slots - # of pending slots
//total slots needed = # of idle slots + tasks.length

//eg 2 - 3A2B2C1D, n = 2
//A _ _ A _ _ A -> 3As with 2 slots in between(since n = 2)
//# of partitions = 3 - 1 = maxFrequency - 1
//# of empty slots = 2 * 2 = n * # of partitions
//# of pending tasks = 2B2C1D = tasks.length - maxFrequency
//# of idle slots = 4 - 5 = Math.max(0, # of empty slots - # of pending slots) -> here case no idle slots are needed
//total slots needed = # of idle slots + tasks.length

//eg 3 - 3A3B1C, n = 2
//A B _ A B _ A B -> 3As with 2 slots in between(since n = 2)
//here AB shouls always be grouped together becasue of same frequency, thus maxCount = 2 i.e 2 tasks must be together
//# of partitions = 3 - 1 = maxFrequency - 1
//# of empty slots = 2 * 1 = (n - maxCount + 1) * # of partitions
//# of pending tasks = 1C = tasks.length - (maxFrequency * maxCount)
//# of idle slots = 2 - 1 = Math.max(0, # of empty slots - # of pending slots) -> here case no idle slots are needed
//total slots needed = # of idle slots + tasks.length

//time - O(n)
//space - O(1) - only upper case letters denoting tasks
class Solution {
    public int leastInterval(char[] tasks, int n) {
        //edge 
        if(tasks == null || tasks.length == 0)
        {
            return 0;
        }
        
        HashMap<Character, Integer> freq = new HashMap<>(); //keeps track of freq of each task
        int maxFreq = 0;
        int maxCount = 0;
        for(char task : tasks) 
        {
            freq.put(task, freq.getOrDefault(task, 0) + 1); //update freq of each task
            maxFreq = Math.max(maxFreq, freq.get(task)); //update maxFreq
        }
        for(char task : freq.keySet())
        {
            int currentFreq = freq.get(task);
            if(currentFreq == maxFreq)
            {
                maxCount++; //update maxCount
            }
        }
        
        int numberOfPartitions = maxFreq - 1;
        int numberofEmptySlots = (n - maxCount + 1) * numberOfPartitions;
        int numberOfPendingSlots = tasks.length - (maxFreq * maxCount);
        int numberOfIdleSlots = Math.max(0, numberofEmptySlots - numberOfPendingSlots);
        
        return tasks.length + numberOfIdleSlots;
    }
}
