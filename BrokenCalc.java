// 991.
class Solution {
    public int brokenCalc(int X, int Y) {
        //at each step * or - is allowed
        //from x, explore both paths i.e subtract 1 from x and double x and continue exploring till y is reached - exponential algorithm
        //* and subtracts complements to / and +
        // thus start from y to reach x while the allowed opns are / and +
        // no need to explore + path at every point because y is already higher tna x and adding 1 increases y further
        // time - O(logn)
        
        int steps = 0; //return value
        while(Y > X)
        {
            if(Y % 2 == 0) //drop from y to y/2 if y is even else add 1 and drop to y/2 at next step
            {
                Y = Y / 2;
            }
            else
            {
                Y = Y + 1;
            }
            steps++;
        }
        //at this point, y < x, add the difference between x and y to steps so far and return
        return steps + (X - Y);
    }
}
