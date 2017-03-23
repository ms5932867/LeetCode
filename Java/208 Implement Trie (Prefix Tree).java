/* 208. Implement Trie (Prefix Tree)
Implement a trie with insert, search, and startsWith methods.

Note:
You may assume that all inputs are consist of lowercase letters a-z.
*/

class TrieNode {
    private TrieNode[] _children;
    private boolean _isWord;
    
    public boolean isWord(){
        return _isWord;
    }
    
    public void setWord(){
        _isWord = true;
    }
    
    public TrieNode getChild(int i){
        return _children[i];
    }
    
    public void setChild(int i, TrieNode node){
        _children[i] = node;
    }
    
    // Initialize your data structure here.
    public TrieNode() {
        _isWord = false;
        _children = new TrieNode[26];
    }
}

public class Trie {
    private TrieNode _root;

    public Trie() {
        _root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = _root;
        for(int i = 0; i < word.length(); i++){
            int index = (int)(word.charAt(i) - 'a');
            if(node.getChild(index) == null){
                node.setChild(index, new TrieNode());
            }
            node = node.getChild(index);
        }
        node.setWord();
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = _root;
        for(int i = 0; i < word.length(); i++){
            int index = (int)(word.charAt(i) - 'a');
            if(node.getChild(index) == null) return false;
            node = node.getChild(index);
        }
        return node.isWord();
        
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = _root;
        for(int i = 0; i < prefix.length(); i++){
            int index = (int)(prefix.charAt(i) - 'a');
            if(node.getChild(index) == null) return false;
            node = node.getChild(index);
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");