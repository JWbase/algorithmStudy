import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> uniqueSums = new HashSet<>();
        int n = elements.length;

        int[] extendedElements = new int[n * 2];
        for (int i = 0; i < n; i++) {
            extendedElements[i] = elements[i];
            extendedElements[i + n] = elements[i];
        }

        for (int length = 1; length <= n; length++) {
            for (int start = 0; start < n; start++) {
                int sum = 0;
                for (int i = 0; i < length; i++) {
                    sum += extendedElements[start + i];
                }
                uniqueSums.add(sum);
            }
        }

        return uniqueSums.size();
    }
}