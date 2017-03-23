/* Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

For example,
add(1); add(3); add(5);
find(4) -> true
find(7) -> false
*/
public class TwoSum {
    // idea : store all numbers and possible 2-sum result in set
    Map<Integer, Integer> map = new HashMap<>(); // number -> # of occur
    
    // Add the number to an internal data structure.
	public void add(int number) {
	    map.put(number, map.containsKey(number) ? map.get(number) + 1 : 1);
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for(Integer n : map.keySet()){
	        int m = value - n;
	        if ((m == n && map.get(n) > 1) || (m != n && map.containsKey(m))) return true;
	    }
	    return false;
	}
}