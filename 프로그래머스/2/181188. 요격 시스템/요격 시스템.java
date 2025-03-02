import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (a, b) -> Integer.compare(a[1], b[1]));
        
        int count = 0;
        double lastShotPosition = -1;
        
        for (int[] target : targets) {
            int start = target[0];
            int end = target[1];            

            if (start >= lastShotPosition) {
                count++;
                lastShotPosition = end - 0.1;
            }
        }
        
        return count;
    }
}