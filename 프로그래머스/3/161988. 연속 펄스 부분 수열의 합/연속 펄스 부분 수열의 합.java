class Solution {
    public long solution(int[] sequence) {
        int n = sequence.length;
        long[] dp1 = new long[n + 1];
        long[] dp2 = new long[n + 1];
        
        int pulse = 1;
        for (int i = 0; i < n; i++) {
            dp1[i + 1] = dp1[i] + (long)sequence[i] * pulse;
            pulse *= -1;
        }
        
        pulse = -1;
        for (int i = 0; i < n; i++) {
            dp2[i + 1] = dp2[i] + (long)sequence[i] * pulse;
            pulse *= -1;
        }
        
        long max1 = Long.MIN_VALUE;
        long min1 = Long.MAX_VALUE;
        long max2 = Long.MIN_VALUE;
        long min2 = Long.MAX_VALUE;
        
        for (int i = 0; i <= n; i++) {
            max1 = Math.max(max1, dp1[i]);
            min1 = Math.min(min1, dp1[i]);
            max2 = Math.max(max2, dp2[i]);
            min2 = Math.min(min2, dp2[i]);
        }
        
        return Math.max(max1 - min1, max2 - min2);
    }
}