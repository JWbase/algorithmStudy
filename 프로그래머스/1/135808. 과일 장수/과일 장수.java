import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        
        int n = score.length;
        for (int i = n - m; i >= 0; i -= m) {
            int minScore = score[i];
            answer += minScore * m;
        }
        
        return answer;
    }
}