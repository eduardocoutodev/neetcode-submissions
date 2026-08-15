class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Map for checking the columns
        // Map for checking sub-grid of 3x3

        // Map for checking the rows
        // Key is row, value is the number
        var rowsMap = new HashMap<Integer, Set<Character>>();

        var columnsMap = new HashMap<Integer, Set<Character>>();

        // Key is the identifier (R-C), where C is columns = currentIndex/3, 
        // and R is rowIdentifier 
        var subGridMap = new HashMap<String, Set<Character>>(); 

        // iterate over the board
        for (int row = 0; row < 9; row++){
            for(int column=0; column < 9; column++){
                var currentValue = board[row][column];
                if(currentValue == '.') continue;

                var currentRowList = rowsMap.getOrDefault(row, new HashSet<Character>());
                if(currentRowList.contains(currentValue)) return false;
                // update row with value
                currentRowList.add(currentValue);
                rowsMap.put(row, currentRowList);
                
                
                var currentColumnList = columnsMap.getOrDefault(column, new HashSet<Character>());
                if(currentColumnList.contains(currentValue)) return false;
                // update column with value
                currentColumnList.add(currentValue);
                columnsMap.put(column, currentColumnList);

                var subgridKey = String.format("%d-%d", row / 3, column / 3);
                var currentSubGrilList = subGridMap.getOrDefault(subgridKey, new HashSet<Character>());
                if(currentSubGrilList.contains(currentValue)) return false;
                // update subgrid with value
                currentSubGrilList.add(currentValue);
                subGridMap.put(subgridKey, currentSubGrilList);
            }
        }

        return true;
    }
}
