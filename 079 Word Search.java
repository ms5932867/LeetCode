/* 79	Word Search
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are 
those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/

public class Solution {
    private char[][] board;
    private String word;
    boolean visited[][];
    
    public boolean exist(char[][] board, String word) {
        if(word.length() == 0) return true;
        if(board.length == 0 && board[0].length == 0) return false;
        
        this.board = board;
        this.word = word;
        
        int m = board.length,
            n = board[0].length;
        visited = new boolean[m][n];
        
        for(int x = 0; x < m; x++){
            for(int y = 0; y < n; y++){
                if(board[x][y] == word.charAt(0)){
                    visited[x][y] = true;
                    if(backtrack(1, x, y)) return true;
                    visited[x][y] = false;
                }
            }
        }
        return false;
    }
    
    private boolean backtrack(int s, int x, int y){
        if(s == word.length()) return true;
        int[][] dir = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        for(int i = 0; i < dir.length; i++){
            int xAdd = dir[i][0],
                yAdd = dir[i][1];
            x += xAdd;
            y += yAdd;
            
            if(x >=0 && x < board.length && y >=0 && y < board[0].length &&
                !visited[x][y] && board[x][y] == word.charAt(s)){
                visited[x][y] = true;
                if(backtrack(s + 1, x, y)) return true;
                visited[x][y] = false;
            }
            
            x -= xAdd;
            y -= yAdd;
            
        }
        return false;
    }
}