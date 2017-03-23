public class Solution {
    List<String> res = new ArrayList<>();
    String tmp = "";
    public List<String> generateParenthesis(int n) {
        if(n > 0) 
            backtrack(n,n);
        return res;
    }
    
    private void backtrack(int left, int right){
        if(right == 0 && left == 0)
            res.add(tmp);
        if(left > 0){
            tmp += '(';
            backtrack(left - 1, right);
            tmp = tmp.substring(0, tmp.length() - 1);
        }
        if(right > left){
            tmp += ')';
            backtrack(left, right - 1);
            tmp = tmp.substring(0, tmp.length() - 1);
        }
    }
}