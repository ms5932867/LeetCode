public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] v = new int[9],
              h = new int[9],
              b = new int[9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    int mask = 1 << (board[i][j] - '0'),
                        k = (i/3)*3 + j/3;
                    if ((v[i] & mask)> 0 || 
                        (h[j] & mask)> 0 || 
                        (b[k] & mask)> 0) return false;
                    v[i] |= mask;
                    h[j] |= mask;
                    b[k] |= mask;
                }
            }
        }
        return true;
    }
}