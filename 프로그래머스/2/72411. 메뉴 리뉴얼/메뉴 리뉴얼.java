import java.util.*;

class Solution {
    Map<String, Integer> combinationCount = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {

        for (int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = new String(arr);
        }
        
        for (int courseLength : course) {
            for (String order : orders) {
                if (courseLength <= order.length()) {
                    generateCombination("", order, courseLength, 0);
                }
            }
        }
        
        Map<Integer, Integer> maxCount = new HashMap<>();
        for (String key : combinationCount.keySet()) {
            int count = combinationCount.get(key);
            if (count >= 2) {
                maxCount.put(key.length(), Math.max(maxCount.getOrDefault(key.length(), 0), count));
            }
        }
        
        List<String> answer = new ArrayList<>();
        for (String key : combinationCount.keySet()) {
            int count = combinationCount.get(key);
            if (count >= 2 && count == maxCount.get(key.length())) {
                answer.add(key);
            }
        }
        
        Collections.sort(answer);
        
        return answer.toArray(new String[0]);
    }
    
    private void generateCombination(String current, String order, int length, int start) {
        if (current.length() == length) {
            combinationCount.put(current, combinationCount.getOrDefault(current, 0) + 1);
            return;
        }
        
        for (int i = start; i < order.length(); i++) {
            generateCombination(current + order.charAt(i), order, length, i + 1);
        }
    }
}