/* 127. Word Ladder
Given two words (beginWord and endWord), and a dictionary's word list, find the 
length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the word list
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
*/

// *************** one direction BFS
public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        // idea: "shortest natually means BFS"
        Set<String> cl = new HashSet<>();
        cl.add(beginWord);
        
        int len = 1;
        while(!cl.isEmpty()){
            Set<String> nl = new HashSet<>();
            for(String s : cl){
                char[] chars = s.toCharArray();
                for(int i = 0; i < chars.length; i++){
                    char old = chars[i];
                    for(char c = 'a'; c <= 'z'; c++){
                        chars[i] = c;
                        String ns = new String(chars);
                        if(ns.equals(endWord)) return len + 1;
                        if(wordList.contains(ns)){
                            nl.add(ns);
                            wordList.remove(ns);
                        }
                    }
                    chars[i] = old;
                }
            }
            cl = nl;
            len++;
        }
        return 0;
    }
}

// ********************* Two direction BFS, much faster!
public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        // idea: "shortest natually means BFS"
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        HashSet<String> visited = new HashSet<String>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        visited.add(beginWord);
        visited.add(endWord);
        int len = 1;
        while(!beginSet.isEmpty() && !endSet.isEmpty()){
            if(beginSet.size() > endSet.size()){ 
			Set<String> tmp = beginSet; beginSet = endSet; endSet = tmp; }
            
            Set<String> next = new HashSet<>();
            for(String s : beginSet){
                char[] chars = s.toCharArray();
                for(int i = 0; i < chars.length; i++){
                    char old = chars[i];
                    for(char c = 'a'; c <= 'z'; c++){
                        chars[i] = c;
                        String ns = new String(chars);
                        if(endSet.contains(ns)) return len + 1;
                        if(!visited.contains(ns) && wordList.contains(ns)){
                            next.add(ns);
                            visited.add(ns);
                        }
                    }
                    chars[i] = old;
                }
            }
            beginSet = next;
            len++;
        }
        return 0;
    }
}