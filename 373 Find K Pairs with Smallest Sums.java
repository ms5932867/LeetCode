public class Solution {
    // idea : use heap, keep a heap of size k
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if(nums1 == null || nums1.length < 1 || nums2 == null || nums2.length < 1 || k < 1) { return res; }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(k); 
        // k = size of priority queue, queue will be ort by the compareTo method defined in Pair
        
        for(int i = 0; i < nums2.length; i++){
            pq.offer(new Pair(0, i, nums1[0] + nums2[i]));
        }
        
        for(int i = 0; i < Math.min(k, nums1.length * nums2.length); i++){
            Pair p = pq.poll();
            res.add(new int[]{nums1[p.i1], nums2[p.i2]});
            
            if(p.i1 + 1 < nums1.length){
                pq.offer(new Pair(p.i1 + 1, p.i2, nums1[p.i1 + 1] + nums2[p.i2]));
            }
        }
        return res;
    }
    
    class Pair implements Comparable<Pair>{
        int i1;
        int i2;
        int sum;
        
        Pair(int i1, int i2, int sum){
            this.i1 = i1;
            this.i2 = i2;
            this.sum = sum;
        }
        
        public int compareTo(Pair toComp){
            return this.sum - toComp.sum;
        }
        
    }
}

/**************************************************************************************/
public class Solution {
    // idea : use heap, keep a heap of size k
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if(nums1 == null || nums1.length < 1 || nums2 == null || nums2.length < 1 || k < 1) { return res; }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(k, new PairComp()); 
        // k = size of priority queue, queue will be ort by the compareTo method defined in Pair
        
        for(int i = 0; i < nums2.length; i++){
            pq.offer(new Pair(0, i, nums1[0] + nums2[i]));
        }
        
        for(int i = 0; i < Math.min(k, nums1.length * nums2.length); i++){
            Pair p = pq.poll();
            res.add(new int[]{nums1[p.i1], nums2[p.i2]});
            
            if(p.i1 + 1 < nums1.length){
                pq.offer(new Pair(p.i1 + 1, p.i2, nums1[p.i1 + 1] + nums2[p.i2]));
            }
        }
        return res;
    }
    
    class Pair{
        int i1;
        int i2;
        int sum;
        
        Pair(int i1, int i2, int sum){
            this.i1 = i1;
            this.i2 = i2;
            this.sum = sum;
        }
    }
    
    class PairComp implements Comparator<Pair>{
        public int compare(Pair p1, Pair p2){
            if(p1.sum > p2.sum) return 1;
            if(p1.sum < p2.sum) return -1;
            return 0;
        }
    }
}