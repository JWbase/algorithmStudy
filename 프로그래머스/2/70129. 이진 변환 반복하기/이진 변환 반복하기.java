class Solution {
    public int[] solution(String s) {
        int transformCount = 0; // 이진 변환 횟수
        int removedZeros = 0; // 제거된 0의 개수

        while(!s.equals("1")) {
            int lengthBefore = s.length(); // 변환 전 길이
            s = s.replace("0", ""); // 모든 0 제거
            int lengthAfter = s.length(); // 0을 제거한 후의 길이
            removedZeros += (lengthBefore - lengthAfter); // 제거된 0의 개수를 더함

            s = Integer.toBinaryString(lengthAfter); // 남은 문자열의 길이를 2진수로 변환
            transformCount++; // 이진 변환 횟수 증가
        }

        return new int[] {transformCount, removedZeros};
    }
}