class Solution {
    int ROWS;
    int COLS;
    int maxArea;

    public int maxAreaOfIsland(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        maxArea = 0;

        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                if(grid[r][c] != 1) continue;
                
                int sum = dfsArea(grid, r, c);
                maxArea = Math.max(maxArea, sum);
            }
        }
        

        return maxArea;
    }

    private int dfsArea(int[][] grid, int row, int col){
        if(Math.min(row, col) < 0|| row >= ROWS || col >= COLS || grid[row][col]!=1){
            return 0;
        }
        // prevent count two times, act as an visited
        grid[row][col]=0;
        int sum = 1;
        sum += dfsArea(grid, row + 1, col);
        sum += dfsArea(grid, row - 1, col);
        sum += dfsArea(grid, row, col + 1);
        sum += dfsArea(grid, row, col - 1);

        return sum;
    }
}
