class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt((i) -> i[0]));

        Stack<int []> stack = new Stack<>();
        for(int i = intervals.length - 1; i >= 0; i--){
            stack.push(intervals[i]);
        }
        
        List<int[]> result = new ArrayList<>();
        while(!stack.isEmpty()){
            int[] current = stack.pop();
            if(stack.isEmpty()) {
                result.add(current);
                break;
            }
            
            int[] next = stack.peek();

            // next.start <= current.end
            if(next[0] <= current[1]){
                stack.pop(); // remove next as well
                // then new result [current.start, next.end]
                int end = Math.max(current[1], next[1]);

                stack.push(new int[]{current[0], end});
            }else {
                // else push current to result, and move on
                result.add(current);
            }
        }
        return result.toArray(int[][]::new);
    }
}
