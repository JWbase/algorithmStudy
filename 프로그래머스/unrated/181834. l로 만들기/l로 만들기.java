class Solution {
    public String solution(String myString) {
        String answer = "";
        char[] charArr = myString.toCharArray();
        for (char c : charArr) {
            if(c < 'l') {
                answer += 'l';
            } else {
                answer += c;
            }
        }
        return answer;
    }
}