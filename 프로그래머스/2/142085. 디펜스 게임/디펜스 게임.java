import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = enemy.length;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int remainingSoldiers = n;
        int remainingShieldUses = k;
        for (int i = 0; i < enemy.length; i++) {
            remainingSoldiers -= enemy[i];
            pq.add(enemy[i]);

            if (remainingSoldiers < 0) {
                if (remainingShieldUses > 0 && !pq.isEmpty()) {
                    remainingSoldiers += pq.poll();
                    remainingShieldUses--;
                } else {
                    answer = i;
                    break;
                }
            }
        }

        return answer;
    }
}