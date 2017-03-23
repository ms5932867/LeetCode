public class Solution {
    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<Character>();
        char[] chars = s.toCharArray();
        for(char c : chars){
            if(!set.add(c)) set.remove(c);
        }
        return set.size() <= 1;
    }
}