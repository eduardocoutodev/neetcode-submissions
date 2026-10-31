class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(newInterval == null || newInterval.length == 0) return intervals;
        if(intervals == null || intervals.length == 0) return new int[][]{newInterval};

        // first find position to insert
        // after insert lets try to merge
        int indexToInsert = 0;
        while(indexToInsert < intervals.length && newInterval[0] > intervals[indexToInsert][0]){
            indexToInsert++;
        }

        List<int []> result = new ArrayList<>();

        for(int[] interval: intervals){
            result.add(interval);
        }
        result.add(indexToInsert, newInterval);

        int i = 0;

        while(i < result.size() - 1){
            // if next.start <= current.end
            int [] current = result.get(i);
            int [] next = result.get(i + 1);

            if(next[0] <= current[1]){
                result.remove(i + 1);
                result.remove(i);
                
                int[] merged = new int[]{current[0], Math.max(current[1], next[1])};
                result.add(i, merged);
                // not incrementing here, because i need to analyze again i and the next one
            }else {
                i++;
            }
        }


        int[][] finalResult = result.toArray(int[][]::new);
        return finalResult;
    }
}
