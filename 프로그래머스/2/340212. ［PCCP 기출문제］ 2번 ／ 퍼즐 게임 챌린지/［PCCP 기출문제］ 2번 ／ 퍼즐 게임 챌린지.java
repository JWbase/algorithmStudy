class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = getMaxDifficulty(diffs);
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canSolveAllPuzzles(diffs, times, mid, limit)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    private int getMaxDifficulty(int[] diffs) {
        int max = 1;
        for (int diff : diffs) {
            max = Math.max(max, diff);
        }
        return max;
    }
    
    private boolean canSolveAllPuzzles(int[] diffs, int[] times, int level, long limit) {
        long totalTime = 0;
        
        for (int i = 0; i < diffs.length; i++) {
            int diff = diffs[i];
            int time_cur = times[i];
            int time_prev = (i > 0) ? times[i - 1] : 0;
            
            if (diff <= level) {
                totalTime += time_cur;
            } else {
                int mistakes = diff - level;
                long mistakeTime = (long) (time_cur + time_prev) * mistakes;
                long finalSolveTime = time_cur;
                
                totalTime += mistakeTime + finalSolveTime;
            }
            
            if (totalTime > limit) {
                return false;
            }
        }
        
        return true;
    }
}