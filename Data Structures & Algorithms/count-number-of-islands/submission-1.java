class Solution {
    int ROWS;
    int COLS;
    int numIslands;

    public int numIslands(char[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        numIslands = 0;

        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                if(grid[r][c] == '1'){
                    numIslands++;
                    dfsIslands(grid, r, c);
                }
            }
        }

        return numIslands;
    }

    private void dfsIslands(char[][] grid, int row, int col){
        if(Math.min(row, col) < 0 || row >= ROWS|| col >= COLS || grid[row][col] == '0'){
            return;
        }

        grid[row][col] = '0';
        dfsIslands(grid, row + 1, col);
        dfsIslands(grid, row - 1, col);
        dfsIslands(grid, row, col + 1);
        dfsIslands(grid, row, col - 1);
    }
}
