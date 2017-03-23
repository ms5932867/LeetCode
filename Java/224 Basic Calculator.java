public class Solution {
    public int calculate(String s) {
        // stack 
        // binary operator, store left operand and operator into stack 
        // '(' : push cur and ope
        // ')' : pop(operator) * cur(right) + next(left), set as new left
        // cur : result of current level
        // sign: sign of right opr
        Stack<Integer> stack = new Stack<>();
        int sign = 1, cur = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '+'){
                sign = 1;
            }
            else if(s.charAt(i) == '-'){
                sign = -1;
            }
            else if(s.charAt(i) == '('){
                stack.push(cur);
                stack.push(sign);
                sign = 1;
                cur = 0;
            }
            else if(s.charAt(i) == ')'){
                cur = cur * stack.pop() + stack.pop();
            }
            else if(s.charAt(i) != ' '){
                int opr = s.charAt(i) - '0';
                while(i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))){
                    opr = opr * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
                cur += sign * opr;
            }
        }
        return cur;
    }
}