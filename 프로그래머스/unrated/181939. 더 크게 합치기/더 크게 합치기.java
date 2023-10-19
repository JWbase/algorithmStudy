class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        String strA = String.valueOf(a);
        String strB = String.valueOf(b);
        if(Integer.parseInt(strA + strB) >= Integer.parseInt(strB + strA)) {
            answer = Integer.parseInt(strA + strB);
        } else {
            answer = Integer.parseInt(strB + strA);
        }
        return answer;
    }
}