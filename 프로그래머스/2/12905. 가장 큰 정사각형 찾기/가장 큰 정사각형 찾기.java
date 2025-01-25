class Solution {
    public int solution(int[][] board) {
        int maxLen = 0;
        int row = board.length;
        int col = board[0].length;
        int[][] dp = new int[row][col];
        
        for (int i = 0; i < row; i++) {
            dp[i][0] = board[i][0];
            maxLen = Math.max(maxLen, dp[i][0]);
        }
        
        for (int j = 0; j < col; j++) {
            dp[0][j] = board[0][j];
            maxLen = Math.max(maxLen, dp[0][j]);
        }
        
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (board[i][j] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        
        return maxLen * maxLen;
    }
}