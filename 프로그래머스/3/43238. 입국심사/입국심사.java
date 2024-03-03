import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long max = (long) n * times[times.length - 1];
        long min = 1;
        long mid = 0;
        long sum;
        long answer = max;

        while (max >= min) {
            sum = 0;
            mid = (max + min) / 2;
            for (int i = 0; i < times.length; i++) { //mid분 동안 각 심사관마다 몇명 심사 가능한지 합산
                sum += mid / times[i];
            }
            if (sum < n) { //n명 보다 적게 심사를 받을 수 있는 경우
                min = mid + 1;
            } else { //n명 보다 많이 심사를 받을 수 있는 경우
                if (mid < answer) {
                    answer = mid;
                }
                max = mid - 1;
            }
        }
        return answer;
    }
}