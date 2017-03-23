public class Solution {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0) return;
        solve(board, 0, 0);
    }
    
    private boolean solve(char[][] board, int I, int J){
        for(int i = I; i < 9; i++){
            for(int j = J; j < 9; j++){
                if(board[i][j] != '.') continue; 
                for(char c = '1'; c <= '9'; c++){
                    if(isValid(board, i, j, c)){
                        board[i][j] = c;
                        
                        if(solve(board, I, J)) { 
                            return true; 
                        }
                        else {
                            board[i][j] = '.';
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }
    
    private boolean isValid(char[][] board, int i, int j, char ch){
        for(int r = 0; r < 9; r++){
            if(board[r][j] == ch) return false;
        }
        
        for(int c = 0; c < 9; c++){
            if(board[i][c] == ch) return false;
        }
        
        int bi = i/3, bj = j/3;
        for(int r = bi * 3; r < bi * 3 + 3; r++){
            for(int c = bj * 3; c < bj *3 + 3; c++){
                if(board[r][c] == ch) return false;
            }
        }
        
        return true;
    }
}