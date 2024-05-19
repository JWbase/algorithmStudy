import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
 List<Integer> indices = new ArrayList<>();
        
        // 배열에서 2의 인덱스를 모두 찾기
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                indices.add(i);
            }
        }
        
        // 2가 배열에 없는 경우 [-1] 반환
        if (indices.isEmpty()) {
            return new int[] {-1};
        }
        
        // 첫 번째 2와 마지막 2의 인덱스를 이용해 부분 배열 생성
        int start = indices.get(0);
        int end = indices.get(indices.size() - 1);
        return Arrays.copyOfRange(arr, start, end + 1);
    }
}