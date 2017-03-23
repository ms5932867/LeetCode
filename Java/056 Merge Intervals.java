/** 56	Merge Intervals
 * Given a collection of intervals, merge all overlapping intervals.

	For example,
	Given [1,3],[2,6],[8,10],[15,18],
	return [1,6],[8,10],[15,18].
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new LinkedList<>();
        if(intervals == null || intervals.size() < 1){ return res; }
        
        Collections.sort(intervals, new IntervalCom());
        Interval pre = intervals.get(0);
        for(int i = 1; i < intervals.size(); i++){
            Interval cur = intervals.get(i);
            if(cur.start <= pre.end){
                pre.end = Math.max(cur.end, pre.end);
            }
            else{
                res.add(pre);
                pre = cur;
            }
        }
        res.add(pre);
        return res;
    }
}

class IntervalCom implements Comparator<Interval>{
    public int compare(Interval i1, Interval i2){
        return i1.start - i2.start;
    }
}