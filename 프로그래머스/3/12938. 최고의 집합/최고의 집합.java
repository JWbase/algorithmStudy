import java.util.Arrays;

class Solution {
    public int[] solution(int n, int s) {
        if (s < n) {
            return new int[]{-1};
        }

        int[] result = new int[n];
        int base = s / n;
        int remainder = s % n;

        Arrays.fill(result, base);

        for (int i = 0; i < remainder; i++) {
            result[n - 1 - i]++;
        }

        return result;
    }
}