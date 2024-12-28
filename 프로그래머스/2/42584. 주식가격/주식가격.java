import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        for (int i = 1; i < n; i++) {
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int j = stack.pop();
                answer[j] = i - j;
            }
            stack.push(i);
        }
        int k = stack.pop();
        answer[k] = 0;
        while(!stack.isEmpty()) {
            int l = stack.pop();
            answer[l] = k - l;
        }
        
        return answer;
    }
}