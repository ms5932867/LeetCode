class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        
        Map<Character, Integer> rec = new HashMap<>();
        for (char c : licensePlate.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                char k = Character.toLowerCase(c);
                if (!rec.containsKey(k)) {
                    rec.put(k, 0);
                }
                rec.put(k, rec.get(k) + 1);
            }
        }
        
        int length = 16;
        String res = "";
        for (String word : words) {
            if (match(rec, word) && word.length() < length) {
                length = word.length();
                res = word;
            }
        }
        return res;
    }
    
    private boolean match(Map<Character, Integer> rec, String word) {
        int[] count = new int[26];
        for (char c : word.toCharArray()) {
            count[c - 'a']++;
        }
        for (char key : rec.keySet()) {
            if (count[key - 'a'] < rec.get(key)) {
                return false;
            }
        }
        //System.out.println(word + " matches");
        return true;
                
    }
}

// after contest
class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {       
        int[] toCompare = build(licensePlate);     
        int length = 16;
        String res = "";
        for (String word : words) {          
            if (word.length() < length) {
                int[] cur = build(word);
                if (match(toCompare, cur)) {
                    length = word.length();
                    res = word;
                }
            }
        }
        return res;
    }
    
    private boolean match(int[] toCompare, int[] src) {        
        for (int i = 0; i < toCompare.length; i++) {
            if (src[i] < toCompare[i]) {
                return false;
            }
        }
        return true;
                
    }
    
    private int[] build(String str) {
        int[] res = new int[26];
        for (char c : str.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                res[Character.toLowerCase(c) - 'a']++;
            }
        }
        return res;
    }
}