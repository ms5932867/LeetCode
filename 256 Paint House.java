/* 256. Paint House
There are a row of n houses, each house can be painted with one of the three colors: 
red, blue or green. The cost of painting each house with a certain color is different. 
You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x 3 cost matrix. 
For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the 
cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.

Note:
All costs are positive integers.
*/
public class Solution {
    public int minCost(int[][] c) {
        if(c == null || c.length == 0) return 0;
        
        int[][] m = new int[c.length][3];
        m[0][0] = c[0][0];
        m[0][1] = c[0][1];
        m[0][2] = c[0][2];
        
        for(int i = 1; i < m.length; i++){
            m[i][0] = c[i][0] + Math.min(m[i-1][1],m[i-1][2]);
            m[i][1] = c[i][1] + Math.min(m[i-1][2],m[i-1][0]);
            m[i][2] = c[i][2] + Math.min(m[i-1][0],m[i-1][1]);
        }
        
        return Math.min(Math.min(m[m.length-1][0], m[m.length-1][1]), m[m.length-1][2]);
    }
}