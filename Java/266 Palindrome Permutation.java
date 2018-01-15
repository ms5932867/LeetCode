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

// *********************************
/* 
The idea is simple, but using set as data structure is not straightforward 
*/
public class Solution {
    public boolean canPermutePalindrome(String s) {
        boolean[] map = new boolean[256];
        char[] chars = s.toCharArray();
        int count = 0;
        for(char c : chars){
            if(map[c]) count--;
            else count++;
            map[c] = !map[c];
        }
        return count <= 1;
    }
}