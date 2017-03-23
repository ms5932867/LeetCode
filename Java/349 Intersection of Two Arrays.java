public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> ans = new HashSet<>();
        Arrays.sort(nums2);
        for(int i = 0; i < nums1.length; i++){
            if(Arrays.binarySearch(nums2, nums1[i]) >= 0)
                ans.add(nums1[i]);
        }
        int[] res = new int[ans.size()];
        int i = 0;
        for(Integer n : ans) res[i++] = n;
        return res;
    }
}