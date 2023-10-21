class Solution {
    public int solution(String myString, String pat) {
        String answer = "";
        for(char c : myString.toCharArray()) {
            if(c == 'A') {
                answer += "B";
            } else {
                answer += "A";
            }
        }
        if(answer.contains(pat)) {
            return 1; 
        }
        return 0;
    }
}