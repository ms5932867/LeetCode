public class Solution {
    public void wallsAndGates(int[][] rooms) {
        // idea: BFS using queue
        if(rooms == null || rooms.length == 0 || rooms[0].length == 0) return;
        
        Queue<int[]> q = new LinkedList<>();
        int m = rooms.length, n = rooms[0].length;
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                if(rooms[i][j] == 0) q.add(new int[]{i,j});
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int i = curr[0], j = curr[1];
            
            if(i > 0 && rooms[i - 1][j] == Integer.MAX_VALUE){
                rooms[i - 1][j] = rooms[i][j] + 1;
                q.add(new int[]{i - 1, j});
            }
            
            if(i + 1 < m && rooms[i + 1][j] == Integer.MAX_VALUE){
                rooms[i + 1][j] = rooms[i][j] + 1;
                q.add(new int[]{i + 1, j});
            }
            
            if(j > 0 && rooms[i][j - 1] == Integer.MAX_VALUE){
                rooms[i][j - 1] = rooms[i][j] + 1;
                q.add(new int[]{i, j - 1});
            }
            
            if(j + 1 < n && rooms[i][j + 1] == Integer.MAX_VALUE){
                rooms[i][j + 1] = rooms[i][j] + 1;
                q.add(new int[]{i, j + 1});
            }
        }
    }
    
    
}