class Solution {
    record Point(int row, int col){}
    List<Point> directions = List.of(
        new Point(1, 0),
        new Point(-1, 0),
        new Point(0, 1),
        new Point(0, -1)
    );
    int COLS;
    int ROWS;
    int healthyFood;

    public int orangesRotting(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        healthyFood = 0;

        Deque<Point> queue = new ArrayDeque<>();


        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                int value = grid[r][c];

                if(value == 0) continue;
                if(value == 1){
                     healthyFood++;
                }
                if(value == 2){
                    queue.addLast(new Point(r, c));
                }
            }
        }

        int minute = 0;
        while(!queue.isEmpty() && healthyFood > 0){
            int pointsToProcess = queue.size();

            for(int i = 0; i < pointsToProcess; i++){
                Point currentPoint = queue.removeFirst();

                for(Point p : directions){
                    int r = currentPoint.row + p.row;
                    int c = currentPoint.col + p.col;

                    if(Math.min(r, c) < 0 || r >= ROWS || c >= COLS || grid[r][c] != 1){
                        continue;
                    }

                    healthyFood--;
                    grid[r][c] = 2;

                    Point pointToVisit = new Point(r, c);
                    queue.addLast(pointToVisit);
                }

            }

            minute++;
        }
        
        return healthyFood > 0 ? -1 : minute;
    }
}
