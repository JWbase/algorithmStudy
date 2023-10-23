import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        /*
            1. 며칠 걸리는지 계산
            2. 이전 날짜보다 작은 건 전부 이전 날짜 , 그 이후 큰 건 1로 초기화
            3. 결과를 배열에 넣고 출력
        */
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
            int day = (100 - progresses[i]) / speeds[i];
            if((100 - progresses[i]) % speeds[i] != 0) {
                day++;
            }
            list.add(day);
        }
        
        List<Integer> depoly = new ArrayList<>();
        for (int i = 0; i < list.size();) {
            int count = 1;
            int workDay = list.get(i);
            
            while(++i < list.size() && workDay >= list.get(i)) {
                count++;
            }
            
            depoly.add(count);
        }
        
        return depoly.stream()
            .mapToInt(i -> i).toArray();
    }
}