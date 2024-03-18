class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        
        // 첫 문자 처리
        boolean isNewWord = true;
        
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            
            // 새 단어의 시작이면
            if (isNewWord) {
                // 해당 문자가 알파벳이면 대문자로 변환
                answer.append(Character.toUpperCase(currentChar));
                isNewWord = false;
            } else {
                // 이외의 경우는 소문자로 변환
                answer.append(Character.toLowerCase(currentChar));
            }
            
            // 공백 문자를 만나면 다음 문자는 새 단어의 시작
            if (currentChar == ' ') {
                isNewWord = true;
            }
        }
        
        return answer.toString();
    }
}