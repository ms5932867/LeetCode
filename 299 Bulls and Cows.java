public class Solution {
    public String getHint(String secret, String guess) {
        int[] nums = new int[10];
        int bulls = 0, cows = 0;
        for(int i = 0; i < guess.length(); i++){
            int s = secret.charAt(i) - '0',
                g = guess.charAt(i) - '0';
            if(s == g) { bulls++; continue;}
            if(nums[s] < 0) cows++;
            if(nums[g] > 0) cows++;
            nums[s]++;
            nums[g]--;
        }
        return bulls + "A" + cows + "B";
    }
}