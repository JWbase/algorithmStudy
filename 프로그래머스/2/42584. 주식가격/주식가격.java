import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        for (int i = 1; i < n; i++) {
            //만약에 i의 값이 이전의 top() 값보다 작으면 주식이 하락됐으니까 기간을 센다.
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int j = stack.pop();
                answer[j] = i - j;
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()) {
            int j = stack.pop();
            answer[j] = n - j - 1;
        }
        
        return answer;
    }
}