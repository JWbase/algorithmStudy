import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> termMap = new HashMap<>();
        
        String[] todayParts = today.split("\\.");
        int todayDate = Integer.parseInt(todayParts[0]) * 12 * 28 + 
                       Integer.parseInt(todayParts[1]) * 28 + 
                       Integer.parseInt(todayParts[2]);
        
        for (String term : terms) {
            String[] parts = term.split(" ");
            termMap.put(parts[0], Integer.parseInt(parts[1]));
        }
        
        for (int i = 0; i < privacies.length; i++) {
            String[] parts = privacies[i].split(" ");
            String[] dateParts = parts[0].split("\\.");
            
            int date = Integer.parseInt(dateParts[0]) * 12 * 28 + 
                      Integer.parseInt(dateParts[1]) * 28 + 
                      Integer.parseInt(dateParts[2]);
            
            int validityPeriod = termMap.get(parts[1]) * 28;
            
            if (date + validityPeriod <= todayDate) {
                answer.add(i + 1);
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}