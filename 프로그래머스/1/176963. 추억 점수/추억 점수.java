import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> yearnMap = new HashMap<>();

        for (int i = 0; i < name.length; i++) {
            yearnMap.put(name[i], yearning[i]);
        }

        for (int i = 0; i < photo.length; i++) {
            int totalYearning = 0;
            for (String person : photo[i]) {
                if (yearnMap.containsKey(person)) {
                    totalYearning += yearnMap.get(person);
                }
            }
            answer[i] = totalYearning;
        }

        return answer;
    }
}