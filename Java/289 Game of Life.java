/* 289. Game of Life
According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a 
cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). 
Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) 
using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state.

Follow up: 
Could you solve it in-place? Remember that the board needs to be updated at the same time: 
You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite, 
which would cause problems when the active area encroaches the border of the array. 
How would you address these problems?
*/

public class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
       // idea: solve in place, input array only use last bit, use second bit from right to store result of next generation
       // [00] -> [00] 0->0 : 
       // [00] -> [10] 0->2 : 3
       // [01] -> [01] 1->1 : more than 3 || less than 2
       // [01] -> [11] 1->3 : 2 || 3
       // a function to compute neighbors is needed
       int m = board.length, n = board[0].length;
       for(int i = 0; i < m; i++){
           for(int j = 0; j < n; j++){
               int nb = getNB(board, i, j);
               if((board[i][j] & 1) == 0 && nb == 3) board[i][j] = 2;
               if((board[i][j] & 1) == 1 && (nb == 2 || nb == 3)) board[i][j] = 3;
           }
       }
       for(int i = 0; i < m; i++){
           for(int j = 0; j < n; j++){
               board[i][j] >>= 1;
           }
       }
       
    }
    
    private int getNB(int[][] board, int i, int j){
        int I = board.length, J = board[0].length;
        int count = board[i][j] == 1 ? -1 : 0;
        for (int ii = Math.max(i - 1, 0); ii <= Math.min(i + 1, I - 1); ii++){
            for (int jj = Math.max(j - 1, 0); jj <= Math.min(j + 1, J - 1); jj++){
                if((board[ii][jj] & 1) > 0) { count++; }
            }
        }
        return count;
    }
}