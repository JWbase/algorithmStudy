import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Map<Character, Character> bracket = new HashMap<>();
        bracket.put('}', '{');
        bracket.put(')', '(');
        bracket.put(']', '[');
        int n = s.length();
        s += s;
        
        A: for (int i = 0; i < n; i++) {
            Deque<Character> stack = new ArrayDeque<>();
            for (int j = i; j < i + n; j++) {
                if (!bracket.containsKey(s.charAt(j))) {
                    stack.push(s.charAt(j));
                } else {
                    if (stack.isEmpty() || stack.pop() != bracket.get(s.charAt(j))) {
                        continue A;
                    }
                }
            }
            if (stack.isEmpty()) {
                answer++;
            }
        }
        
        return answer;
    }
}