public class ZigzagIterator {
    
    private Iterator<Integer> t1, t2;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        t1 = v2.iterator();
        t2 = v1.iterator();
    }

    public int next() {
        if(t2.hasNext()){
            Iterator<Integer> tmp = t1;
            t1 = t2;
            t2 = tmp;
        }
        return t1.next();
    }

    public boolean hasNext() {
        return t1.hasNext() || t2.hasNext();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */