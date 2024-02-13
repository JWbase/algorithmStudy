import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        int time = 0;
        int totalWeight = 0;
        
        for (int i=0; i<truck_weights.length; i++) {
            while (true) {
                if (queue.isEmpty()) {
                    queue.offer(truck_weights[i]);
                    totalWeight += truck_weights[i];
                    time++;
                    break;
                } else if (queue.size() == bridge_length) {
                    totalWeight -= queue.poll();
                } else {
                    if (totalWeight + truck_weights[i] > weight) {
                        queue.offer(0);
                        time++;
                    } else {
                        queue.offer(truck_weights[i]);
                        totalWeight += truck_weights[i];
                        time++;
                        break;
                    }
                }
            }
        }
        return time + bridge_length;
    }
}