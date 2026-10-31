class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length <= 1) return 0;

        Arrays.sort(intervals, Comparator.comparingInt(i -> i[1]));
        
        int conflicts = 0;
        int lastKeptEnd = intervals[0][1];
        
        for(int i = 1; i < intervals.length ; i++){
            int[] interval = intervals[i];

            if(interval[0] >= lastKeptEnd){
                lastKeptEnd = interval[1];
            }else{
                conflicts++;
            }
        }

        return conflicts;
    }
}
