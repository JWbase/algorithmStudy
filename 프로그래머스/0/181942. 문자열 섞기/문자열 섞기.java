class Solution {
    public String solution(String str1, String str2) {
        String answer = "";
        String[] sStr1 = str1.split("");
        String[] sStr2 = str2.split("");
        for (int i = 0; i < str1.length(); i++) {
            answer += sStr1[i];
            answer += sStr2[i];
        }
        return answer;
    }
}