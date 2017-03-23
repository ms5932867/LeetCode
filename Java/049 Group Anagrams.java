/* 49. Group Anagrams
Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
*/

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // strings belong to the same group should have same character set
        // when sorted, the should be the same, used as key for a group
        // data structure: map : key -> list of anagrams
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            String k = getKey(str);
            if(!map.containsKey(k)){
                map.put(k, new ArrayList<String>());
            }
            map.get(k).add(str);
        }
        
        for(String k : map.keySet()){
            res.add(map.get(k));
        }
        return res;
    }
    
    private String getKey(String str){
        char[] chrs = str.toCharArray();
        Arrays.sort(chrs);
        return new String(chrs);
    }
}