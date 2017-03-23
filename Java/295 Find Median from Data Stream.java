public class MedianFinder {
    Queue<Integer> small = new PriorityQueue<>(),
                   big   = new PriorityQueue<>();
                   
    // Adds a number into the data structure.
    public void addNum(int num) {
        small.add(-num);
        big.add(-small.poll());
        if(big.size() > small.size() + 1){
            small.add(-big.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(big.size() > small.size()) return big.peek();
        else{ return (big.peek() - small.peek()) / 2.0;}
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();