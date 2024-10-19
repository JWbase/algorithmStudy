import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

        int cameraCount = 0;
        int cameraPosition = Integer.MIN_VALUE;

        for (int[] route : routes) {
            if (cameraPosition < route[0]) {
                cameraPosition = route[1];
                cameraCount++;
            }
        }

        return cameraCount;
    }
}