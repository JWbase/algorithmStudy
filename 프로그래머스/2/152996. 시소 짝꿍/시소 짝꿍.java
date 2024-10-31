import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Integer, Integer> weightCount = new HashMap<>();
        
        for (int weight : weights) {
            weightCount.put(weight, weightCount.getOrDefault(weight, 0) + 1);
        }
        
        for (int weight : weightCount.keySet()) {
            long count = weightCount.get(weight);
            if (count > 1) {
                answer += (count * (count - 1)) / 2;
            }
            
            if (weight * 3 % 2 == 0) {
                int targetWeight = weight * 3 / 2;
                if (weightCount.containsKey(targetWeight)) {
                    answer += (long) weightCount.get(weight) * weightCount.get(targetWeight);
                }
            }
            
            if (weight * 2 % 1 == 0) {
                int targetWeight = weight * 2;
                if (weightCount.containsKey(targetWeight)) {
                    answer += (long) weightCount.get(weight) * weightCount.get(targetWeight);
                }
            }
            
            if (weight * 4 % 3 == 0) {
                int targetWeight = weight * 4 / 3;
                if (weightCount.containsKey(targetWeight)) {
                    answer += (long) weightCount.get(weight) * weightCount.get(targetWeight);
                }
            }
        }
        
        return answer;
    }
}