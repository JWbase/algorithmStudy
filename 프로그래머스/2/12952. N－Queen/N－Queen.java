class Solution {
    public int solution(int n) {
        return solveNQueens(n);
    }
    
    private int solveNQueens(int n) {
        int[] queens = new int[n];
        return backtrack(queens, 0, n);
    }
    
    private int backtrack(int[] queens, int row, int n) {
        if (row == n) {
            return 1;
        }
        
        int count = 0;
        for (int col = 0; col < n; col++) {
            if (isValid(queens, row, col)) {
                queens[row] = col;
                count += backtrack(queens, row + 1, n);
            }
        }
        
        return count;
    }
    
    private boolean isValid(int[] queens, int row, int col) {
        for (int i = 0; i < row; i++) {
            int prevCol = queens[i];
            
            if (prevCol == col) {
                return false;
            }
            
            int rowDiff = row - i;
            int colDiff = Math.abs(col - prevCol);
            
            if (rowDiff == colDiff) {
                return false;
            }
        }
        
        return true;
    }
}