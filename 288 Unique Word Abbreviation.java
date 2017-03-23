public class ValidWordAbbr {
	// idea: Map key->word, if two word has same key, the map value will be set to ""
    Map<String, String> map = new HashMap<>();
    
    public ValidWordAbbr(String[] dictionary) {
        for(String w : dictionary){
            String key = getAbbr(w);
            if(map.containsKey(key) && !map.get(key).equals(w)){
                map.put(key, "");
            }
            else{
                map.put(key, w);
            }
        }
    }

    public boolean isUnique(String word) {
        String key = getAbbr(word);
        if(map.containsKey(key)){
            return map.get(key).equals(word);
        }
        return true;
    }
    
    private String getAbbr(String word){
        if(word.length() <= 2) return word;
        return word.charAt(0) + Integer.toString(word.length() - 2) + word.charAt(word.length() - 1);
    } 
}