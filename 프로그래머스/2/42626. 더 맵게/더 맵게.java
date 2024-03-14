import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int s : scoville) {
            pq.offer(s);
        }
        
        int answer = 0;
        while (pq.size() > 1 && pq.peek() < K) {
            int least = pq.poll();
            int secondLeast = pq.poll();
            
            int mixed = least + (secondLeast * 2);
            pq.offer(mixed);
            answer++;
        }
        
        if (pq.peek() >= K) {
            return answer;
        }
        
        return -1;
    }
}