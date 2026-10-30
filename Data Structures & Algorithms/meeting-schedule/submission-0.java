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
        Deque<Interval> queue = new ArrayDeque<>();

        for(Interval interval : intervals){
            queue.offerLast(interval);
        }

        while(queue.size() > 1){
            Interval current = queue.pollFirst();
            Interval next = queue.peekFirst();

            // sei que o next.start >= current.start
            if(next.start < current.end) return false;
        }
        
        return true;
    }
}
