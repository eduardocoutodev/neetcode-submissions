class Solution {
    record Point(int row, int col){}
    int ROWS;
    int COLS;
    Set<Point> visited;
    int numIslands;

    public int numIslands(char[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        numIslands = 0;
        visited = new HashSet<>();

        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                Point p = new Point(r, c);
                if(visited.contains(p)) continue;
                if(grid[r][c] == '1'){
                    numIslands++;
                    dfsIslands(grid, r, c);
                }
            }
        }

        return numIslands;
    }

    private void dfsIslands(char[][] grid, int row, int col){
        Point p = new Point(row, col);
        if(Math.min(row, col) < 0 || row >= ROWS|| col >= COLS || visited.contains(p)){
            return;
        }

        visited.add(p);
        if(grid[row][col] == '0'){
            return;
        }

        dfsIslands(grid, row + 1, col);
        dfsIslands(grid, row - 1, col);
        dfsIslands(grid, row, col + 1);
        dfsIslands(grid, row, col - 1);
    }
}
