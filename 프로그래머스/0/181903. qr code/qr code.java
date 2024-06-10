class Solution {
    public String solution(int q, int r, String code) {
        StringBuilder answer = new StringBuilder();
        int length = code.length();
        for (int i = r; i < length; i += q) {
            answer.append(code.charAt(i));
        }
        return answer.toString();
    }
}