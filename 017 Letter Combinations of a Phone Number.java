/*  17. Letter Combinations of a Phone Number
Given a digit string, return all possible letter combinations that the number could represent.
Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
*/
public class Solution {
    List<String> res = new ArrayList<>();
    String tmp = "";
    public List<String> letterCombinations(String digits) {
        
        if(digits.length() == 0) return res;
        
        Map<Character, String> map = new HashMap<>();
        map.put('2',"abc"); 
        map.put('3', "def"); 
        map.put('4', "ghi"); 
        map.put('5', "jkl");
        map.put('6', "mno"); 
        map.put('7', "pqrs"); 
        map.put('8', "tuv"); 
        map.put('9', "wxyz");
        
        char[] chars = digits.toCharArray();
        backtrack(map, chars, 0);
        return res;
    }
    
    private void backtrack(Map<Character, String> map, char[] chars, int s){
        if(s == chars.length){
            res.add(tmp);
            return;
        }
        for(char c : map.get(chars[s]).toCharArray()){
            tmp += c;
            backtrack(map, chars, s + 1);
            tmp = tmp.substring(0, tmp.length() - 1);
        }
    }
}