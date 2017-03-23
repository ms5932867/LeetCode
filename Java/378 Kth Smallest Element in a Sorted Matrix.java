public class Solution {
    // idea: use a heap
    public int kthSmallest(int[][] matrix, int k) {
        
        PriorityQueue<Number> pq = new PriorityQueue<>(k);
        int m = matrix.length,
            n = matrix[0].length;
            
        for(int j = 0; j < n; j++){
            pq.offer(new Number(0, j, matrix[0][j]));
        }
        for(int i = 1; i < k; i++){
            Number cur = pq.poll();
            if(cur.x + 1 < m){
                pq.offer(new Number(cur.x + 1, cur.y, matrix[cur.x + 1][cur.y]));
            }
        }
        return pq.poll().v;
    }
    
    class Number implements Comparable<Number>{
        int x, y, v;
        public int compareTo(Number toComp){
            return this.v - toComp.v;
        }
        
        Number(int x, int y, int v){
            this.x = x;
            this.y = y;
            this.v = v;
        }
    }
}