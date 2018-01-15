class Solution {
    public int countCornerRectangles(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (!map.containsKey(i)) {
                        map.put(i, new HashSet<>());
                    }
                    map.get(i).add(j);
                }
            }
        }
        
        int res = 0;
        for (int i1 = 0; i1 < m; i1++) {
            for (int i2 = i1 + 1; i2 < m; i2++) {
                if (map.containsKey(i1) && map.containsKey(i2)) {
                    int k = intersect(map.get(i1), map.get(i2));
                    res += k * (k - 1) / 2;
                }
            }
        }
        return res;
    }
    
    private int intersect(Set<Integer> s1, Set<Integer> s2) {
        int res = 0;
        for (int k1 : s1) {
            if (s2.contains(k1)) {
                res++;
            }
        }
        return res;
    }
}
// After contest, from others
class Solution {
    public int countCornerRectangles(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;   
        
        for (int i1 = 0; i1 < m; i1++) {
            for (int i2 = i1 + 1; i2 < m; i2++) {
                int count = 0;
                for (int k = 0; k < n; k++) {
                    if (grid[i1][k] == 1 && grid[i2][k] == 1) {
                        count++;
                    }
                }
                if (count > 1) {
                    res += count * (count - 1) / 2;
                }            
            }
        }
        return res;
    }
}