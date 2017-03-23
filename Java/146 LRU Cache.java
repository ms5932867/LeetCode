/* 146	LRU Cache
Design and implement a data structure for Least Recently Used (LRU) cache. 
It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, 
otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. W
hen the cache reached its capacity, it should invalidate the least recently 
used item before inserting a new item.
*/
public class LRUCache {
    private class Node{
        int key;
        int value;
        Node prev;
        Node next;
        
        Node(int k, int v){
            key = k;
            value = v;
        }
        
        Node(){}
        
        public void SetPrev(Node p){
            prev = p;
        }
        
        public Node GetPrev(){
            return prev;
        }
        
        public void SetNext(Node n){
            next = n;
        }
        
        public Node GetNext(){
            return next;
        }
        
        public void SetValue(int v){
            value = v;
        }
        
        public int GetValue(){
            return value;
        }
        
        public int GetKey(){
            return key;
        }
    }
    // remove a node from double-liked list
    private void removeNode(Node node){
        node.GetNext().SetPrev(node.prev);
        node.GetPrev().SetNext(node.next);
    }
    // remove the tail node from double-linked list
    private Node removeTail(){
        Node node = _tail.prev;
        removeNode(node);
        return node;
    }
    // add a node on the front of head
    private void addToHead(Node node){
        node.SetPrev(_head);
        node.SetNext(_head.next);
        _head.SetNext(node);
        node.GetNext().SetPrev(node);
    }
    // move a existing node to the top of double-linked list
    private void moveToHead(Node node){
        removeNode(node);
        addToHead(node);
    }
    
    // private variables
    private Map<Integer, Node> _map; // <key, Node(key, value)>
    private int _capacity;
    private int _count;
    private Node _head, _tail;
    
    public LRUCache(int capacity) {
        _count = 0;
        _capacity = capacity;
        
        _head = new Node();
        _tail = new Node();
        
        _head.SetPrev(null);
        _head.SetNext(_tail);
        
        _tail.SetPrev(_head);
        _tail.SetNext(null);
        
        _map =  new HashMap<Integer, Node>();
    }
    
    public int get(int key) {
        Node node = _map.get(key);
        if(node == null){
            //throw new Exception("Cannot found value for key " + key);
            return -1;
        }
        moveToHead(node);
        return node.GetValue();
    }
    
    public void set(int key, int value) {
        Node node = _map.get(key);
        if(node != null){
            node.SetValue(value);
            moveToHead(node);
        }
        else{
            Node newNode = new Node(key, value);
            _map.put(key, newNode);
            addToHead(newNode);
            _count++;
            
            if(_count > _capacity){
                Node removeNode = removeTail();
                _map.remove(removeNode.GetKey());
                _count--;
            }
        }
    }
}