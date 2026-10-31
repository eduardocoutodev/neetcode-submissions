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
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.isEmpty()) return 0;

        intervals.sort(Comparator.comparingInt((i)-> i.start));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // conflict = next.start < current.end 
        int currentRooms = 0;
        int maxRoomsNeeded = 0;


        for(int i = 0; i < intervals.size(); i++){
            Interval current = intervals.get(i);

            while(!pq.isEmpty() && pq.peek() <= current.start){
                // remove already ended meeting
                pq.poll();
                currentRooms--;
            }

            currentRooms++;
            maxRoomsNeeded = Math.max(maxRoomsNeeded, currentRooms);
            
            pq.offer(current.end);
        }


        return maxRoomsNeeded;
    }
}
