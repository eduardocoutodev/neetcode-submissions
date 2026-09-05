class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;
        int[] foundRow = null;

        while(left <= right){
            int m = left + (right - left) / 2;
            int[] row = matrix[m];

            // Validar se o valor de target esta na row
            if(row[0] <= target && row[row.length - 1] >= target){
                // found row
                foundRow = row;
                break;
            }

            if(target > row[row.length - 1]){
                // move left pointer to middle
                left = m + 1;
            }

            if(target < row[0]){
                right = m - 1;
            }
        }

        if(foundRow == null) return false;

        left = 0;
        right = foundRow.length - 1;
        

        while(left <= right){
            int m = left + (right - left) / 2;
            if(foundRow[m] == target) return true;

            if(foundRow[m] > target){
                right = m - 1;
            }else {
                left = m + 1;
            }
        }


        return false;
    }
}
