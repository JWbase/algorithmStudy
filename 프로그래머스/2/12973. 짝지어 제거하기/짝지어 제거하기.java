import java.util.*;

class Solution {
    public int solution(String s) {
                // 문자열을 처리하기 위한 스택 생성
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            // 스택이 비어있지 않고, 현재 문자와 스택의 맨 위 문자가 같으면 스택에서 해당 문자 제거
            if(!stack.isEmpty() && stack.peek() == currentChar) {
                stack.pop();
            } else {
                // 다르면 스택에 문자 추가
                stack.push(currentChar);
            }
        }

        // 스택이 비어있으면 모든 문자가 짝지어 제거된 것이므로 1 반환, 그렇지 않으면 0 반환
        return stack.isEmpty() ? 1 : 0;
    }
}