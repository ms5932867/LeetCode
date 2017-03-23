/* 200. Number of Islands
Given  a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
An island is surrounded by water and is formed by connecting adjacent lands 
horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
*/

public class Solution {
    static int[][] dir = new int[][]{{-1,1,0,0},
                                    {0,0,-1,1}};
                                    
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int res = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    mark(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }
    
    private void mark(char[][] grid, int i, int j){
        grid[i][j] = '2';
        for(int d = 0; d < dir[0].length; d++){
            int ni = i + dir[0][d],
                nj = j + dir[1][d];
            if(ni >= 0 && ni < grid.length && nj >= 0 && nj < grid[0].length && grid[ni][nj] == '1'){
                mark(grid, ni, nj);
            } 
        }
        
    }
}