/* 380. Insert Delete GetRandom O(1)
Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. 
Each element must have the same probability of being returned.
*/
public class RandomizedSet {
    ArrayList<Integer> nums; // only array could support random access
    HashMap<Integer, Integer> index;
    
    java.util.Random rand = new java.util.Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        nums = new ArrayList<Integer>();
        index = new HashMap<Integer, Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (index.containsKey(val)) return false;
        index.put(val, nums.size());
        nums.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!index.containsKey(val)) return false;
        int ind = index.get(val);
        if (ind < nums.size() - 1) { // not the last one than swap the last one with this val
            int lastone = nums.get(nums.size() - 1);
            nums.set(ind, lastone);
            index.put(lastone, ind);
        }
        index.remove(val);
        nums.remove(nums.size() - 1); // remove the last element in array is quick
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */