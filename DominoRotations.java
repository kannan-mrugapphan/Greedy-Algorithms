// 1007.
class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        //edge
        if(A == null || B == null || A.length != B.length)
        {
            return 0; //invalid input - no rotations needed
        }
        
        return minRotations2(A, B);
    }
    
    //time - O(n)
    //space - constant
    private int minRotations(int[] A, int[] B) {
        // a potential number that could fill all cells in A or in B should be between 1 and 6 and have a frequency of atleast length of one of the given arrays 
        int candidate = 0; //potential candidate
        for(int i = 1; i < 7; i++)
        {
            int freqI = 0;
            for(int j = 0; j < A.length; j++)
            {
                //whenever i is seen in either arrays increase freq of i by 1
                if(A[j] == i)
                {
                    freqI++;
                }
                if(B[j] == i)
                {
                    freqI++;
                }
            }
            if(freqI >= A.length) //if freq condition is met, replace candidate with i and break
            {
                candidate = i;
                break;
            }
        }
        
        //each cell in A must be candidate or each cell in B must be candidate
        int ARotations = 0; //ARotations tracks rotations needed to make all cells in A as candidate
        int BRotations = 0; //BRotations tracks rotations needed to make all cells in B as candidate
        for(int i = 0; i < A.length; i++)
        {
            if(A[i] != candidate && B[i] != candidate)
            {
                // ith index in both A and B are not equal to candidate, so reqd result is not possible
                return -1;
            }
            else if(A[i] != candidate)
            {
                ARotations++; //rotate A[i] so A[i] is candidate - thus ARotations is increased by 1
            }
            else if(B[i] != candidate)
            {
                BRotations++; //rotate B[i] so B[i] is candidate - thus BRotations is increased by 1
            }
        }
        
        return Math.min(ARotations, BRotations); //return min
    }
    
    //time - O(n)
    //space - constant
    private int minRotations2(int[] A, int[] B) {
        //candidate should be one between A[0] or B[0]
        //return min rotations between 2 possible candidates
        int result = Math.min(rotations(A, B, A[0]), rotations(A, B, B[0]));
        return result == Integer.MAX_VALUE ? -1 : result ;
    }
    
    private int rotations(int[] A, int[] B, int candidate) {
        //each cell in A must be candidate or each cell in B must be candidate
        int ARotations = 0; //ARotations tracks rotations needed to make all cells in A as candidate
        int BRotations = 0; //BRotations tracks rotations needed to make all cells in B as candidate
        for(int i = 0; i < A.length; i++)
        {
            if(A[i] != candidate && B[i] != candidate)
            {
                // ith index in both A and B are not equal to candidate, so reqd result is not possible
                return Integer.MAX_VALUE;
            }
            else if(A[i] != candidate)
            {
                ARotations++; //rotate A[i] so A[i] is candidate - thus ARotations is increased by 1
            }
            else if(B[i] != candidate)
            {
                BRotations++; //rotate B[i] so B[i] is candidate - thus BRotations is increased by 1
            }
        }
        
        return Math.min(ARotations, BRotations); //return min
    }
}
