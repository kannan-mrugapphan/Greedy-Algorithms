// 455.
// time - sorting + O(max(number of children, number of cookies))
// space - constant
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        //sort the cookies and children based on decreasing order of size of cookies and greed factor of child respectively
        //greedily satisfy the most greediest child first 
        //assign largest cookie to most greediest child (if possible)
        
        Arrays.sort(g);
        Arrays.sort(s);
        int contentChildren = 0; //return value
        int currentCookie = s.length - 1; //initially the largest available cookie
        int currentChild = g.length - 1; //initially the most greedy child
        
        //there are more unassigned children and cookies left
        while(currentCookie >= 0 && currentChild >= 0)
        {
            if(s[currentCookie] >= g[currentChild])
            {
                //current cookie is larger than current child's greed factor - assign
                currentCookie--;
                currentChild--;
                contentChildren++;
            }
            else
            {
                currentChild--; //current child cant be satisfied with any cookie due to decreasing order of cookie sizes
            }
        }
        
        return contentChildren;
    }
}
