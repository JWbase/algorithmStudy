class Solution {
    public int[] solution(int[] arr) {
        
        // 배열 arr의 길이
        int len = arr.length;
        // 2의 거듭제곱 중 arr의 길이보다 크거나 같은 가장 작은 값을 찾기 위한 변수
        int targetLength = 1;
        
        // arr의 길이가 2의 거듭제곱이 될 때까지 targetLength를 2배씩 증가
        while (targetLength < len) {
            targetLength *= 2;
        }
        
        // 추가해야 하는 0의 개수 계산
        int addZeroCount = targetLength - len;
        // 결과 배열 초기화 (기존 배열 길이 + 추가할 0의 개수)
        int[] result = new int[targetLength];
        
        // 기존 배열의 내용을 결과 배열에 복사
        System.arraycopy(arr, 0, result, 0, len);
                
        return result;
    }
}