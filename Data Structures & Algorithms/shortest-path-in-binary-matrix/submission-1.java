class Solution {
    record Coordinate(int row, int col){}
    record CoordinateWithSteps(Coordinate coordinate, int steps){}

    private int COLS;
    private int ROWS;
    private Set<Coordinate> visited;
    private Integer shortestNumberOfSteps;
    private List<Coordinate> DIRECTION_COORDINATES = List.of(
        new Coordinate(1, 0),
        new Coordinate(0, 1),
        new Coordinate(-1, 0),
        new Coordinate(0, -1),
        new Coordinate(1, 1),
        new Coordinate(-1, 1),
        new Coordinate(-1, 1),
        new Coordinate(-1, -1)
    );

    public int shortestPathBinaryMatrix(int[][] grid) {
        COLS = grid.length;
        ROWS = grid[0].length;

        if(grid[0][0] != 0 || grid[ROWS - 1][COLS - 1] != 0) return -1;

        visited = new HashSet<>();
        shortestNumberOfSteps = Integer.MAX_VALUE;
        Deque<CoordinateWithSteps> queue = new ArrayDeque<>();
        queue.add(new CoordinateWithSteps(new Coordinate(0,0), 1));
        
        while(!queue.isEmpty()){
            int elementsToProcess = queue.size();
            for(int i = 0; i < elementsToProcess; i++){
                CoordinateWithSteps coordinateToProcess = queue.pop();

                int row = coordinateToProcess.coordinate.row;
                int col = coordinateToProcess.coordinate.col;
                int steps = coordinateToProcess.steps;

                if(row == ROWS - 1 && col == COLS - 1) {
                    shortestNumberOfSteps = Math.min(shortestNumberOfSteps, steps);
                    continue;
                }

                if(!shouldAdvance(grid, row, col, steps)){
                    continue;
                }

                visited.add(coordinateToProcess.coordinate);
                for(Coordinate c: DIRECTION_COORDINATES){
                    queue.add(new CoordinateWithSteps(new Coordinate(row + c.row, col + c.col), steps + 1));
                }
            }

        }

        return shortestNumberOfSteps == Integer.MAX_VALUE ? -1 : shortestNumberOfSteps;
    }

    private boolean shouldAdvance(int[][] grid, int row, int col, int numberSteps){
        Coordinate coordinate = new Coordinate(row, col);

        if(Math.min(row, col) < 0 || row >= ROWS || col >= COLS || visited.contains(coordinate) || grid[row][col] !=0 || numberSteps >= shortestNumberOfSteps){
            return false;
        }

        return true;
    }
}