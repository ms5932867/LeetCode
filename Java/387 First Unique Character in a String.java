/* 387. First Unique Character in a String
 * Given a string, find the first non-repeating character in 
 * it and return it's index. If it doesn't exist, return -1.
*/
public class Solution {
    public int firstUniqChar(String s) {
        int[] mem = new int[26];
        Arrays.fill(mem, -1);
        for(int i = 0; i < s.length(); i++){
            int index = s.charAt(i) - 'a';
            if(mem[index] == -1){
                mem[index] = i;
            }else if(mem[index] >= 0){
                mem[index] = -2;
            }
        }
        
        int res = Integer.MAX_VALUE;
        for(int n : mem){
            if(n >= 0 && res > n){
                res = n;
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}

public class Solution {
    public int firstUniqChar(String s) {
        int[] mem = new int[26];
        for(int i = 0; i < s.length(); i++){
            int index = s.charAt(i) - 'a';
            mem[index]++;
        }
        

        for(int i = 0; i < s.length(); i++){
            if(mem[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }
}