// 1055.
// time - O(length of source * length of target) - worst case occurs when source = abc and target = cba
//space - constant
class Solution {
    public int shortestWay(String source, String target) {
        int result = 0; //return val
        int tp = 0; // tp iterates over source and target
        
        while(tp < target.length())
        {
            int current = tp; //store initial tp
            for(int i = 0; i < source.length(); i++)
            {
                //iterate through source, if char match occurs, increment tp
                if(tp < target.length() && source.charAt(i) == target.charAt(tp))
                {
                    tp++;
                }
            }
            if(tp == current) //if tp doent increment after one iteration return -1
            {
                return -1;
            }
            result++; //increment result by 1 after 1 iteration through source
        }
        
        return result;
    }
}
