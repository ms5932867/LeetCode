public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(String str : strings){
            String key = getKey(str);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(str);
        }
        List<List<String>> res = new ArrayList<List<String>>();
        for(String key : map.keySet()){
            res.add(map.get(key));
        }
        return res;
    }
    
    private String getKey(String str){
        if(str == null) return null;
        String key = "";
        char c = str.charAt(0);
        for(int i = 0; i < str.length(); i++){
            int cur = (str.charAt(i) - c);
            if (cur < 0) cur += 26;
            key += (char)cur + 'a';
        }
        return key;
    }
}