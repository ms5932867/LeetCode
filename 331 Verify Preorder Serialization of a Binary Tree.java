public class Solution {
    public boolean isValidSerialization(String preorder) {
        // stack
        // two consecutive '#' means a leaf node
        Stack<String> stack = new Stack<>();
        String[] strs = preorder.split(",");
        for(int i = 0; i < strs.length; i++){
            String s = strs[i];
            if(s.equals("#")){
                while(!stack.isEmpty() && stack.peek().equals(s)){
                    stack.pop();
                    if(stack.isEmpty()) return false;
                    stack.pop();
                }
                stack.push(s);
            }
            else{
                stack.push(s);
            }
        }
        
        return stack.size() == 1 && stack.peek().equals("#");
    }
}