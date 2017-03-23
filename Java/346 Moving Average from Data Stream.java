public class MovingAverage {
    //idea : queue is the abstract data-structure for this
    private LinkedList<Integer> _win;
    private int _count, _size;
    private int _sum;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        _win = new LinkedList<>();
        _count = 0;
        _size = size;
        _sum = 0;
    }
    
    public double next(int val) {
        if(_count < _size){
            _sum += val;
            _count++;
        }
        else{
            _sum -= _win.poll();
            _sum += val;
        }
        _win.add(new Integer(val));
        return (double)_sum / _count;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */