// 55.

class Solution {
    public boolean canJump(int[] nums) {
        //edge
        if(nums == null || nums.length < 2)
        {
            return true; //array size smaller than 2, already at end
        }
        
        return greedySoln(nums);
    }
    
    //time - O(max element in nums[] * length of nums[])
    //space - O(length of nums[])
    private boolean dfs(int[] nums, int index) {
        //base
        if(index >= nums.length - 1)
        {
            return true;
        }
        //logic
        for(int i = 1; i <= nums[index]; i++)
        {
            //jumps at each index could be from magnitude 1 upto magnitude = number at that index
            if(dfs(nums, index + i)) //jump to each possible index and recurse
            {
                return true;
            }
        }
        return false;
    }
    
    //time - O(n)
    //space - constant
    private boolean greedySoln(int[] nums) {
        int destination = nums.length - 1; //have to reach end of nums[]
        for(int i = nums.length - 2; i >= 0; i--)
        {
            //from each previous index, check if dest is reachable, if so update dest else try with prev index
            if(i + nums[i] >= destination)
            {
                //dest reachable from i
                destination = i; //update dest
            }
            if(destination == 0) //if start is reached
            {
                return true;
            }
        }
        return false; //end not reachable from start
    }
}
