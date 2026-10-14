class Solution {
    private int ROWS, COLS;
    private boolean [][] visited;

    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;
        visited = new boolean[ROWS][COLS];

        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(dfs(board, word, i, j, 0)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int row, int column, int i){
        if(i == word.length()){
            return true;
        }

        // backtrack if col or row out of grid
        if(row < 0 || column < 0 || row >= ROWS || column >= COLS){
            return false;
        }

        if(board[row][column] != word.charAt(i)) return false;

        // backtrack if already visited
        if(visited[row][column]) return false;


        visited[row][column] = true;
        boolean res = 
            // Check row to the above
            dfs(board, word, row + 1, column, i + 1) || 
            // Check row to the below
            dfs(board, word, row - 1, column, i + 1) || 
            // Check column to the left
            dfs(board, word, row, column - 1, i + 1) || 
            // Check column to the right
            dfs(board, word, row, column + 1, i + 1);

        visited[row][column] = false;
        return res;
    }
}
