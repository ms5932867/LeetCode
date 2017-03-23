/* 362. Design Hit Counter
Design a hit counter which counts the number of hits received in the past 5 minutes.

Each function accepts a timestamp parameter (in seconds granularity) and you may assume 
that calls are being made to the system in chronological order 
(ie, the timestamp is monotonically increasing). You may assume that the earliest 
timestamp starts at 1.

It is possible that several hits arrive roughly at the same time.
*/

public class HitCounter {
    // using a queue will cause too much memory if 
    // hits frequnce is high in a second
    // for the design, you need to ask how this interfaces are used
    // consider time complexity and space comsumption
    // ask for granularity
    
    int[] count;
    int[] time;
    /** Initialize your data structure here. */
    public HitCounter() {
        count = new int[300];
        time = new int[300];
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int index = timestamp % 300; // hits at 6s and 306s will be stored in the same place 
        if(time[index] == timestamp){
            count[index]++;
        }
        else{
            time[index] = timestamp;
            count[index] = 1;
        }
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int res = 0;
        for(int i = 0; i < 300; i++){
            if(timestamp - time[i] < 300)
                res += count[i];
        }
        return res;
    }
}

public class HitCounter {

    class Tuple {
        int time;
        int count;
        public Tuple(int time, int count) {
            this.time = time;
            this.count = count;
        }
    }
    
    Queue<Tuple> q;
    int currCount;

    public HitCounter() {
        q = new LinkedList<>();
        currCount = 0;
    }
    
    public void hit(int timestamp) {
        advance(timestamp);
        if(!q.isEmpty() && q.peek().time==timestamp) {
            q.peek().count += 1;
        } else {
            q.offer(new Tuple(timestamp, 1));
        }
        currCount += 1;
    }
    
    private void advance(int timestamp) {
        while(!q.isEmpty() && q.peek().time <= timestamp - 300) {
            currCount -= q.poll().count;
        }
    }
    
    public int getHits(int timestamp) {
        advance(timestamp);
        return currCount;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */