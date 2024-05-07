class Solution {
    public int solution(String myString, String pat) {
        int count = 0; // 패턴이 등장하는 횟수를 저장할 변수
        int patLength = pat.length(); // 패턴의 길이

        // myString의 각 문자에 대해 반복
        for (int i = 0; i <= myString.length() - patLength; i++) {
            // 현재 위치에서 패턴의 길이만큼의 부분 문자열이 패턴과 일치하는지 확인
            if (myString.substring(i, i + patLength).equals(pat)) {
                count++; // 일치하면 count를 증가시킴
            }
        }

        return count; // 최종 계산된 등장 횟수 반환
    }
}