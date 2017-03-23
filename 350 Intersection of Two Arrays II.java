public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        
        for(int i = 0; i < nums1.length; i++){
            int key = nums1[i];
            if(map.containsKey(key)) map.put(key, map.get(key) + 1);
            else map.put(key, 1);
        }
        
        for(int j = 0; j < nums2.length; j++){
            int key = nums2[j];
            if(map.containsKey(key)){
                res.add(key);
                int rem = map.get(key) - 1;
                if(rem == 0) map.remove(key);
                else map.put(key, rem);
            }
        }
        
        int[] ans = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
}