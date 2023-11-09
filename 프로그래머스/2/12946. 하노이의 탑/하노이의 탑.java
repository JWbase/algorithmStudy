import java.util.*;

class Solution {
    int[][] answer;
    int count = 0;
    
    public int[][] solution(int n) {
        answer = new int[(int) (Math.pow(2, n) - 1)][2];
        hanoi(n,1,2,3);
        return answer;
    }
    
    private void hanoi(int n, int start, int middle, int end) {
        if(n == 1) {
            answer[count][0] = start;
            answer[count][1] = end;
            count++;
        } else {
            hanoi(n - 1, start, end, middle);
            answer[count][0] = start;
            answer[count][1] = end;
            count++;
            hanoi(n - 1, middle, start, end);
        }
    }
}