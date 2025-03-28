class Solution {
    public int solution(int[][] triangle) {
        int height = triangle.length;
        int[][] dp = new int[height][height];
        dp[0][0] = triangle[0][0];
        
        for (int i = 1; i < height; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                }
                else if (j == i) {
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
                }
            }
        }
        
        int max = 0;
        for (int j = 0; j < height; j++) {
            max = Math.max(max, dp[height-1][j]);
        }
        
        return max;
    }
}