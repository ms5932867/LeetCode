/* 150. Evaluate Reverse Polish Notation
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
*/
public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s : tokens){
            if(s.equals("-")){
                Integer b = stack.pop(), a = stack.pop();
                stack.push(a - b);
            }
            else if(s.equals("+")){
                stack.push(stack.pop() + stack.pop());
            }
            else if(s.equals("/")){
                Integer b = stack.pop(), a = stack.pop();
                stack.push(a / b);
            }
            else if(s.equals("*")){
                stack.push(stack.pop() * stack.pop());
            }
            else{
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}