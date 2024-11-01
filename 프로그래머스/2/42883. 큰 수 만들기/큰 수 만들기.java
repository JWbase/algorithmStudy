class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int len = number.length();
        int answerLength = len - k;
        int startIndex = 0;
        
        for (int i = 0; i < answerLength; i++) {
            char maxDigit = '0';
            int maxIndex = startIndex;
            
            int endIndex = len - (answerLength - i);
            for (int j = startIndex; j <= endIndex; j++) {
                if (number.charAt(j) > maxDigit) {
                    maxDigit = number.charAt(j);
                    maxIndex = j;
                }
            }
            
            answer.append(maxDigit);
            startIndex = maxIndex + 1;
        }
        
        return answer.toString();
    }
}