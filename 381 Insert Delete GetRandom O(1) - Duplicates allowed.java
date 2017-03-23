public class RandomizedCollection {
    ArrayList<Integer> nums;
    HashMap<Integer, Set<Integer>> index;
    java.util.Random rand = new java.util.Random();
    
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        nums = new ArrayList<Integer>();
        index = new HashMap<Integer, Set<Integer>>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contain = index.containsKey(val);
        if (!contain) index.put(val, new HashSet<Integer>()); 
        index.get(val).add(nums.size());        
        nums.add(val);
        return !contain ;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!index.containsKey(val)) return false;
        
        int ind = index.get(val).iterator().next();
            index.get(val).remove(ind);
            
        if (ind < nums.size() - 1) {
            int lastone = nums.get(nums.size() - 1);
            nums.set(ind, lastone);
            index.get(lastone).remove(nums.size() - 1);
            index.get(lastone).add(ind);
        }
        
        nums.remove(nums.size() - 1);
        if (index.get(val).isEmpty()) index.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get( rand.nextInt(nums.size()) );
    }
}


/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */