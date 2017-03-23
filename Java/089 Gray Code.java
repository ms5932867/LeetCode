public class Solution {
    public List<Integer> grayCode(int n) {
        // idea : consider each bit from right to left
        // when adding a new bit, mirror the current result, set the new bit, append to current result
        if(n < 0) return new ArrayList<>();
        List<Integer> res = new ArrayList<Integer>(1 << n);  
        res.add(0, 0);
        if(n == 0) return res;
        res.add(1, 1);
        int preLen = 2;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < preLen; j++){
                res.add(preLen + j, res.get(preLen - 1 - j) + (1 << i));
            }
            preLen <<= 1;
        }
        return res;
    }
}