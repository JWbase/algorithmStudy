import java.util.*;

class Solution {
    public String solution(String s) {
String[] numbers = s.split(" ");
        int[] intNumbers = new int[numbers.length];
        
        // 문자열 배열을 정수 배열로 변환
        for (int i = 0; i < numbers.length; i++) {
            intNumbers[i] = Integer.parseInt(numbers[i]);
        }
        
        // 정수 배열 정렬
        Arrays.sort(intNumbers);
        
        // 최소값과 최대값을 문자열로 변환하여 반환
        String answer = intNumbers[0] + " " + intNumbers[intNumbers.length - 1];
        return answer;
    }
}