/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {

        if(intervals.isEmpty()) {
            return true;
        }
        
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

        Interval prev = intervals.get(0);

        for(int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            if(curr.start >= prev.end) {
                prev = curr;
            } else {
                return false; // overlap
            }
        }

        return true;
    }
}
