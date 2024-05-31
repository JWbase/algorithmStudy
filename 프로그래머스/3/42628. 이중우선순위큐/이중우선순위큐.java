import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (String operation : operations) {
            String[] op = operation.split(" ");
            if (op[0].equals("I")) {
                int num = Integer.parseInt(op[1]);
                minHeap.offer(num);
                maxHeap.offer(num);
            } else {
                if (minHeap.isEmpty()) continue;
                if (op[1].equals("1")) {
                    int maxVal = maxHeap.poll();
                    minHeap.remove(maxVal);
                } else {
                    int minVal = minHeap.poll();
                    maxHeap.remove(minVal);
                }
            }
        }

        if (minHeap.isEmpty()) {
            return new int[]{0, 0};
        } else {
            int maxVal = maxHeap.poll();
            int minVal = minHeap.poll();
            return new int[]{maxVal, minVal};
        }
    }
}