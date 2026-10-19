class Solution {
    record Point(int row, int col){}
    int ROWS;
    int COLS;

    int INF = Integer.MAX_VALUE;
    //boolean [][] visited;
    List<Point> directions = List.of(
        new Point(1, 0),
        new Point(-1, 0),
        new Point(0, 1),
        new Point(0, -1)
    );

    public void islandsAndTreasure(int[][] grid) {
        // if we are on INF
        ROWS = grid.length;
        COLS = grid[0].length;

        Deque<Point> queue = new ArrayDeque<>();


        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                if(grid[r][c] != 0) continue;

                queue.addLast(new Point(r, c));
            }
        }

        if(queue.isEmpty()) return;
        while(!queue.isEmpty()){
            Point p = queue.removeFirst();
            int row = p.row;
            int col = p.col;
            for(Point direction: directions){
                int newR = row + direction.row;
                int newCol = col + direction.col;

                if(Math.min(newR, newCol) < 0 || newR >= ROWS || newCol >= COLS || grid[newR][newCol] != INF){
                    continue;
                }
                grid[newR][newCol]=grid[row][col] + 1;

                queue.add(new Point(newR, newCol));
            }
        }
    }

}
