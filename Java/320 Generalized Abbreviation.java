public class Solution {
    List<String> res = new ArrayList<>();
    StringBuilder tmp = new StringBuilder();
    public List<String> generateAbbreviations(String word) {
        backtrack(word, 0, 0);
        return res;
    }
    private void backtrack(String word, int s, int acc){
        int len = tmp.length();
        if(s == word.length()){
            if(acc != 0) tmp.append(acc);
            res.add(tmp.toString());
            tmp.setLength(len);
            return;
        }
        
        backtrack(word, s + 1, acc + 1);
        
        if(acc != 0) tmp.append(acc);
        tmp.append(word.charAt(s));
        backtrack(word, s + 1, 0);
        tmp.setLength(len);
    }
}