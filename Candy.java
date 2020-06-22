// 135.
// time - O(n)
// space - O(n)
class Solution {
    public int candy(int[] ratings) {
        //edge
        if(ratings == null || ratings.length == 0)
        {
            return 0;
        }
        
        int[] result = new int[ratings.length];
        Arrays.fill(result, 1); //all children must receive atleast 1 candy
        
        //left pass
        for(int i = 1; i < ratings.length; i++)
        {
            //if current child has a higher rating than prev child, increase # of candies of current by 1 + # of candies of prev
            if(ratings[i] > ratings[i - 1])
            {
                result[i] = 1 + result[i - 1];
            }
        }
        
        //right pass
        for(int i = ratings.length - 2; i >= 0; i--)
        {
            //if current child has a higher rating than next child and has smller # of candies than next, increase # of candies of current by 1 + # of candies of next
            if(ratings[i] > ratings[i + 1] && result[i] <= result[i + 1])
            {
                result[i] = 1 + result[i + 1];
            }
        }
        
        int numberOfCandies = 0; //return all candies assigned so far
        for(int number : result)
        {
            numberOfCandies += number;
        }
        
        return numberOfCandies;
    }
}
