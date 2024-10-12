import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int work : works) {
            pq.offer(work);
        }
        
        while (n > 0 && !pq.isEmpty()) {
            int maxWork = pq.poll();
            if (maxWork > 0) {
                pq.offer(maxWork - 1);
            }
            n--;
        }
        
        long result = 0;
        while (!pq.isEmpty()) {
            int work = pq.poll();
            result += (long) work * work;
        }
        
        return result;
    }
}