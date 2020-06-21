// 948.
// time = sorting + O(n)
//space - constant

class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        
        //gain a point by spending minimum power or loose a point and gain maximum power possible
        Arrays.sort(tokens);
        
        //low tracks tokens on which points are gained
        //high tracks tokens on which power is gained
        int low = 0;
        int high = tokens.length - 1;
        
        int maxPoints = 0; //return val
        int points = 0;
        
        //as long as there are more tokens to process
        while(low <= high)
        {
            if(P >= tokens[low]) //spend power, gain point and move to next token
            {
                P -= tokens[low];
                low++;
                points++;
                maxPoints = Math.max(maxPoints, points); //update max points if needed
            }
            else if(points > 0) //loose point, gain power and move to next token
            {
                points--;
                P += tokens[high];
                high--;
            }
            else //both are not possible so return max so far
            {
                return maxPoints;
            }
        }
        
        return maxPoints;
    }
}
