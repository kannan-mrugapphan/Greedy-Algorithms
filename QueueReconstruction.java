// 406.
// time - O(n^2)
// space - constant

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        //edge
        if(people == null || people.length == 0 || people[0].length == 0)
        {
            return people; 
        }
        
        //person[] is of form {height, people taller than current and in front of current}
        //sort the people[][] based on decreasing order of height and increasing order of k value in case of same height
        Arrays.sort(people, (int[] a, int[] b) -> {
            if(a[0] == b[0])
            {
                return a[1] - b[1];
            }
            else
            {
                return b[0] - a[0];
            }
        });
        
        //insert people[i] at people[i][1]th index of the result list
        //it works beacuse current person i is samller than previous i - 1 people (due to sorted nature)
        //placing this ith person at its k value wont affect the previous taller already placed
        ArrayList<int[]> result = new ArrayList<>();
        for(int[] person : people)
        {
            result.add(person[1], person);
        }
        
        return result.toArray(new int[0][]);
    }
}
