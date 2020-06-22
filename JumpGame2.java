// 45.
class Solution {
    
    int minJumps;
    
    public int jump(int[] nums) {
        //edge
        if(nums == null || nums.length < 2)
        {
            return 0; //already at end
        }
        // minJumps = Integer.MAX_VALUE;
        // dfs(nums, 0, 0);
        // return minJumps;
        return minJumpsGreedy(nums);
    }
    
    //time - O(max element in nums[] * length of nums[])
    //space - O(length of nums[])
    private void dfs(int[] nums, int index, int jumps) {
        //base
        if(index >= nums.length - 1)
        {
            //last index is reached or overshooted
            minJumps = Math.min(minJumps, jumps);
            return;
        }
        //logic
        for(int i = 1; i <= nums[index]; i++)
        {
            //jumps at each index could be from magnitude 1 upto magnitude = number at that index
            dfs(nums, index + i, jumps + 1); //jump to index + i and recurse
        }
        return;
    }
    
    //time - O(n^2)
    //space - O(n)
    private int minJumpsDP(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[0] = 0; //if nums.length = 1, min jumps is 0 to reach end of nums[]
        
        for(int i = 1; i < nums.length; i++)
        {
            //for each subsequent index, check if that is index is reaachable from any prev index
            for(int j = 0; j < i; j++)
            {
                if(j + nums[j] >= i)
                {
                    //i reachable from j
                    result[i] = Math.min(result[i], 1 + result[j]); //update result[i]
                }
            }
        }
        
        return result[nums.length - 1];
    }
    
    //time - O(n)
    //space - O(1)
    private int minJumpsGreedy(int[] nums) {
        int currentStairs = nums[0]; //max index reachable from start
        int currentLadder = nums[0]; //current ladder at any point tracks largest reachable index from current
        int jumps = 1; //return val - atleast 1 jump needed if nums[] length >= 2
        for(int i = 1; i < nums.length; i++)
        {
            //if end is reached return jumps 
            if(i == nums.length - 1)
            {
                return jumps;
            }
            //if a larger ladder is found, make it as the current ladder
            if(i + nums[i] > currentLadder)
            {
                currentLadder = i + nums[i]; 
            }
            currentStairs--; 
            if(currentStairs == 0) //jump to the ladder if stairs end is reached and update the stairs with ladder - current index
            {
                jumps++; 
                currentStairs = currentLadder - i;
            }
        }
        return jumps;
    }
}
