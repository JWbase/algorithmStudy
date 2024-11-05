class Solution {
    public int solution(int[][] dots) {
        if (checkParallel(dots[0], dots[1], dots[2], dots[3])) {
            return 1;
        }
        
        if (checkParallel(dots[0], dots[2], dots[1], dots[3])) {
            return 1;
        }
        
        if (checkParallel(dots[0], dots[3], dots[1], dots[2])) {
            return 1;
        }
        
        return 0;
    }
    
    private boolean checkParallel(int[] dot1, int[] dot2, int[] dot3, int[] dot4) {
        
        double slope1 = calculateSlope(dot1, dot2);
        
        double slope2 = calculateSlope(dot3, dot4);
        
        return Math.abs(slope1 - slope2) <= 0.00000001;
    }
    
    private double calculateSlope(int[] dot1, int[] dot2) {
        return (double)(dot2[1] - dot1[1]) / (dot2[0] - dot1[0]);
    }
}