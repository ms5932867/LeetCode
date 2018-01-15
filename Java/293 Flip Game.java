public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res =  new ArrayList<>();
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == '+' && s.charAt(i - 1) == '+'){
                res.add(s.substring(0, i - 1) + "--" + s.substring(i + 1, s.length()));
            }
        }
        return res;
    }
}

public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res =  new ArrayList<>();
        char[] chars = s.toCharArray();
        for(int i = 1; i < chars.length; i++){
            if(chars[i] == '+' && chars[i - 1] == '+'){
                res.add(new String(chars, 0, i - 1) + "--" + new String(chars, i + 1, s.length() - (i + 1)));
            }
        }
        return res;
    }
}