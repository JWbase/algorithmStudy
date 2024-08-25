class Solution {
    public int solution(String dartResult) {
        int[] scores = new int[3];
        int index = -1;
        int length = dartResult.length();
        
        for (int i = 0; i < length; i++) {
            char ch = dartResult.charAt(i);
            
            if (Character.isDigit(ch)) {
                index++;
                if (ch == '1' && i + 1 < length && dartResult.charAt(i + 1) == '0') {
                    scores[index] = 10;
                    i++;
                } else {
                    scores[index] = ch - '0';
                }
            } else if (ch == 'S') {
                scores[index] = (int) Math.pow(scores[index], 1);
            } else if (ch == 'D') {
                scores[index] = (int) Math.pow(scores[index], 2);
            } else if (ch == 'T') {
                scores[index] = (int) Math.pow(scores[index], 3);
            } else if (ch == '*') {
                scores[index] *= 2;
                if (index > 0) {
                    scores[index - 1] *= 2;
                }
            } else if (ch == '#') {
                scores[index] *= -1;
            }
        }
        
        return scores[0] + scores[1] + scores[2];
    }
}