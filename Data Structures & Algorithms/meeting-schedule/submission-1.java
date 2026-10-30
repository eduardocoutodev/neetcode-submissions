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
        intervals.sort(Comparator.comparingInt((i) -> i.start));

        for(int i = 0; i < intervals.size() - 1; i++){
            Interval current = intervals.get(i);
            Interval next = intervals.get(i + 1);

            // sei que o next.start >= current.start
            if(next.start < current.end) return false;
        }

        return true;
    }
}
