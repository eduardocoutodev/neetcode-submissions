class Solution {
    record Point(int row, int column){}
    List<Point> directions = List.of(
        new Point(1, 0),
        new Point(0, 1),
        new Point(-1, 0),
        new Point(0, -1)
    );

    boolean [][] pacific;
    boolean [][] atlantic;

    int COLS;
    int ROWS;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROWS = heights.length;
        COLS = heights[0].length;

        pacific = new boolean[ROWS][COLS];
        atlantic = new boolean[ROWS][COLS];

        Deque<Point> pacificQueue = new ArrayDeque<>();
        Deque<Point> atlanticQueue = new ArrayDeque<>();

        for(int c = 0; c < COLS; c++){
            pacificQueue.addLast(new Point(0, c));
            atlanticQueue.addLast(new Point(ROWS - 1, c));
        }

        for(int r = 0; r < ROWS; r++){
            pacificQueue.addLast(new Point(r, 0));
            atlanticQueue.addLast(new Point(r, COLS - 1));
        }

        bfs(heights, pacificQueue, pacific);
        bfs(heights, atlanticQueue, atlantic);

        List<List<Integer>> solution = new ArrayList<>();
        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                if(pacific[r][c] && atlantic[r][c]){
                    solution.add(List.of(r,c));
                }
            }
        }

        return solution;
    }

    private void bfs(int[][] heights, Deque<Point> queue, boolean [][] ocean){
        while(!queue.isEmpty()){
            Point currentPoint = queue.removeFirst();
            int r = currentPoint.row;
            int c = currentPoint.column;
            ocean[r][c] = true;

            for(Point direction: directions){
                int nextR = r + direction.row;
                int nextC = c + direction.column;

                if(Math.min(nextR, nextC) < 0 || nextR >= ROWS || nextC >= COLS || ocean[nextR][nextC] || heights[r][c] > heights[nextR][nextC]) continue;

                queue.addLast(new Point(nextR, nextC));
            }
        }
    }
}
