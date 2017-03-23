/* 174. Dungeon Game
The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon.
 The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially 
 positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his 
health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) 
upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that 
increase the knight's health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only 
rightward or downward in each step.
*/
public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon == null || dungeon.length == 0 || dungeon[0].length == 0){//[],[[]]
            return 0;
        }
        int[][] flag = new int[dungeon.length][dungeon[0].length];
        int min = dfs(dungeon, flag, 0, 0);
        return min;
    }
    
    private int dfs(int[][] dungeon, int[][] flag, int x, int y){
        if(flag[x][y] != 0){
            return flag[x][y];
        }
        if(x == dungeon.length - 1 && y == dungeon[0].length - 1){//The down-right corner
            flag[x][y] = dungeon[x][y] < 0 ? -dungeon[x][y] + 1 : 1; //The minimum is 1
            return flag[x][y];
        }
        int min = Integer.MAX_VALUE;
        //go down
        if(x < dungeon.length - 1){
            int down = dfs(dungeon, flag, x + 1, y);
            min = min < down ? min : down; 
        }
        //go right
        if(y < dungeon[0].length - 1){
            int right = dfs(dungeon, flag, x, y + 1);
            min = min < right ? min : right;
        }
        if(dungeon[x][y] >= min){//If min is 6, dungeon[x][y] if 10, then min should be updated to 1
            min = 1;
        }else{//If min is 6, dungeon[x][y] is 3 or -3, then min should be updated to 3 or 9
            min = min - dungeon[x][y];
        }
        flag[x][y] = min;
        return min;
    }
}

public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        
        int m = dungeon.length, i, j;
        if(m == 0)
            return 0;
        int n = dungeon[0].length;
        
        int[][] requirement = new int[m][n];
        
        requirement[m-1][n-1] = Math.max(1 , 1-dungeon[m-1][n-1]);
     
        for(i=m-2;i>=0;i--) {
            requirement[i][n-1] = Math.max(1 , requirement[i+1][n-1] - dungeon[i][n-1]);
        }   
        
        for(i=n-2;i>=0;i--) {
            requirement[m-1][i] = Math.max(1 , requirement[m-1][i+1] - dungeon[m-1][i]);
        }   
        
        for(i=m-2;i>=0;i--) {
            for(j=n-2;j>=0;j--) {
                requirement[i][j] = Math.max(1 , Math.min(requirement[i+1][j] , 
				requirement[i][j+1]) - dungeon[i][j]);
            }
        }
        
        return requirement[0][0];
    }
}