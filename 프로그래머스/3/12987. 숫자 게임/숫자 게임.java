import java.util.*;

class Solution {
        public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int aIndex = 0;
        int bIndex = 0;
        int winCount = 0;

        while (aIndex < A.length && bIndex < B.length) {
            if (B[bIndex] > A[aIndex]) {
                winCount++;
                aIndex++;
            }
            bIndex++;
        }

        return winCount;
    }
}