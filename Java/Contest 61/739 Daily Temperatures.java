class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;        
        Stack<Integer> s = new Stack<Integer>();                
        int[] res = new int[n];
        
        for (int i = 0; i < n; i++) {
            int cur = temperatures[i];
            if (s.isEmpty() || temperatures[s.peek()] >= cur) {
                s.push(i);
                continue;
            }
            while (!s.isEmpty() && temperatures[s.peek()] < cur) {
                res[s.peek()] = i - s.pop();
            }
            s.push(i);
        }
        
        while (!s.isEmpty()) {
            res[s.pop()] = 0;
        }
        return res;
    }
}

// After contest
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;        
        Stack<Integer> s = new Stack<Integer>();                
        int[] res = new int[n];
        
        for (int i = 0; i < n; i++) {
            int cur = temperatures[i];
            while (!s.isEmpty() && temperatures[s.peek()] < cur) {
                res[s.peek()] = i - s.pop();
            }
            s.push(i);
        }
        
        while (!s.isEmpty()) {
            res[s.pop()] = 0;
        }
        return res;
    }
}