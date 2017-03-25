class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_map<char, bool> r; // whether a character exists in current window s[b, e)
        int b = 0, e = 0, m = 0;
        
        while(e < s.length()){
            char c = s[e];
            if(r[c] == true){
                m = max(m, e - b);
                while(s[b] != c)
                    r[s[b++]] = false;
                b++;
            }else
                r[c] = true;
            e++;
        }
        return max(m, e - b);
    }
};