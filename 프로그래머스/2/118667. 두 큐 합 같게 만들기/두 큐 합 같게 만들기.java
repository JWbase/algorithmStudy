import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Long> q1 = new LinkedList<>();
        Queue<Long> q2 = new LinkedList<>();
        
        long sum1 = 0;
        long sum2 = 0;
        
        for(int i = 0; i < queue1.length; i++) {
            q1.add((long)queue1[i]);
            q2.add((long)queue2[i]);
            sum1 += queue1[i];
            sum2 += queue2[i];
        }
        
        if((sum1 + sum2) % 2 != 0) return -1;
        
        int count = 0;
        int limit = queue1.length * 3;
        
        while(sum1 != sum2) {
            if(count >= limit) return -1;
            
            if(sum1 > sum2) {
                long value = q1.poll();
                q2.add(value);
                sum1 -= value;
                sum2 += value;
            } else {
                long value = q2.poll();
                q1.add(value);
                sum2 -= value;
                sum1 += value;
            }
            count++;
        }
        
        return count;
    }
}