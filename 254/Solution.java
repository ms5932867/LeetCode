// https://leetcode.com/problems/factor-combinations/

class Solution {
    public List<List<Integer>> getFactors(int n) {
        return getFactors(n, 2);
    }
    
    private List<List<Integer>> getFactors(int n, int minFactor) {
        List<List<Integer>> res = new LinkedList<>();
        if (n <= minFactor) return res;
                
        for (int f = minFactor; f * f <= n; f++) {
            if (n % f == 0) {
                List<Integer> c = new LinkedList(Arrays.asList(f, n/f));
                res.add(c);
                for (List<Integer> li : getFactors(n / f, f)) {
                    c = new LinkedList(Arrays.asList(f));
                    c.addAll(li);
                    res.add(c);
                }
            }
        }
        return res;
    }
}
