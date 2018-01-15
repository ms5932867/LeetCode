public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> ans = new HashSet<>();
        Arrays.sort(nums2);
        for(int t : nums1){
            if(Arrays.binarySearch(nums2, t) >= 0)
                ans.add(t);
        }
        int[] res = new int[ans.size()];
        int i = 0;
        for(Integer n : ans) res[i++] = n;
        return res;
    }
}

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> ans = new HashSet<>();
        Arrays.sort(nums2);
        for(int t : nums1){
            if(Arrays.binarySearch(nums2, t) >= 0)
                ans.add(t);
        }
        Integer[] tmp = ans.toArray(new Integer[0]);
        return Arrays.stream(tmp).mapToInt(Integer::intValue).toArray();
    }
}

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums2);
        Arrays.sort(nums1);
        int[] res = new int[Math.min(nums1.length, nums2.length)];
        int c = 0;
        for(int i = 0, j = 0; i < nums1.length && j < nums2.length;){
            int n1 = nums1[i], n2 = nums2[j];
            if(n1 == n2) { 
                if(c == 0 || (c > 0 && res[c - 1] != n1)) res[c++] = n1; 
                i++; 
                j++; 
            }
            else if(n1 < n2) i++;
            else j++;
        }
        return Arrays.copyOf(res, c);
    }
}