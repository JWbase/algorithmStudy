import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
         int answer = 0;
        
        // 배열 A를 오름차순으로 정렬
        Arrays.sort(A);
        // 배열 B를 내림차순으로 정렬
        Arrays.sort(B);
        
        for (int i = 0; i < A.length; i++) {
            // 배열 A의 i번째 원소와 배열 B의 (B.length - 1 - i)번째 원소를 곱하여 누적합 계산
            // 배열 B를 내림차순으로 정렬하였으므로, B의 가장 큰 값부터 시작해야 하므로 (B.length - 1 - i) 사용
            answer += A[i] * B[B.length - 1 - i];
        }
        
        return answer;
    }
}