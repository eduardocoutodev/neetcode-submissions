class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int [] result = new int[queries.length];
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        // sortedQueries[i][0] = query, sortedQueries[i][0] = originalIndex
        int [][] sortedQueries = new int[queries.length][2];
        for(int i = 0; i < queries.length; i++){
            int query = queries[i];
            sortedQueries[i]=new int[]{query, i};
        }

        Arrays.sort(sortedQueries, Comparator.comparingInt(i -> i[0]));

        // Min heap sorted by range
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparingInt((i)-> (i[1] - i[0]) + 1)
        );
        
        int nextIndex = 0;
        for(int[] queryArray: sortedQueries){
            int query = queryArray[0];
            int originalIndex = queryArray[1];

            // while to offer to pq and increment next index
            while(nextIndex < intervals.length && intervals[nextIndex][0] <= query){
                pq.offer(intervals[nextIndex]);
                nextIndex++;
            }

            while(!pq.isEmpty() && pq.peek()[1] < query){
                pq.poll();
            }
            // while to peek and remove older intervals
            result[originalIndex] = pq.isEmpty() ? -1 : (pq.peek()[1] - pq.peek()[0] + 1);
        }

        return result;
    }

    private boolean isInsideInterval(int[] interval, int numberToTest){
        return interval[0] <= numberToTest && numberToTest <= interval[1]; 
    }
}
