public class MovingAverage {
    //idea : queue is the abstract data-structure for this
    private LinkedList<Integer> _win;
    private int _size;
    private long _sum;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        _win = new LinkedList<>();
        _size = size;
        _sum = 0;
    }
    
    public double next(int val) {
        _win.add(new Integer(val));
        _sum += val;
        if(_win.size() > _size){
            _sum -= _win.poll();
        }
        
        return (double)_sum / _win.size();
    }
}

public class MovingAverage {
    //idea : queue is the abstract data-structure for this
    private int[] win;
    private int n, insert;
    private long sum;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        win = new int[size];
        insert = 0;
        n = 0;
        sum = 0;
    }
    
    public double next(int val) {
        sum += val;
        sum -= win[insert];
        win[insert] = val;
        insert = (insert + 1) % win.length;
        if(n < win.length) n++;
        return (double)sum / n;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */