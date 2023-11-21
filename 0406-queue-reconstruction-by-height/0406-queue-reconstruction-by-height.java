class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // 우선 순위 큐 선언, 정렬 기준은 큰 키 우선, 값이 같다면 앞에 줄 서 있는 사람이 작은 순으로
        Queue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] != b[0] ? 
                    b[0] - a[0] : a[1] - b[1]
        );
        
        for (int[] person : people) {
            pq.add(person);
        }
        List<int[]> result = new ArrayList<>();
        
        while(!pq.isEmpty()) {
            //큰 키 우선, 앞에 줄 서 있는 사람이 작은 순으로 추출
            int[] person = pq.poll();
            // 앞에 줄 서 있는 사람을 인덱스로 해서 삽입
            result.add(person[1], person);
        }
        return result.toArray(new int[people.length][2]);
    }
}