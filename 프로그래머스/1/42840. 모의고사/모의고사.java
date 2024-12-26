import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[][] patterns = {
            {1,2,3,4,5},
            {2,1,2,3,2,4,2,5},
            {3,3,1,1,2,2,4,4,5,5}
        };        
        int[] answer = {0, 0, 0};

        for(int i = 0; i < patterns.length; i++) {
          for (int j = 0; j < answers.length; j++) {
              if (answers[j] == patterns[i][j % patterns[i].length]) {
                  answer[i]++;
              }
          }  
        }
        int maxScore = Arrays.stream(answer).max().getAsInt();
        
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < answer.length; i++) {
            if (answer[i] == maxScore) {
                list.add(i + 1);
            }
        }
        
        return list.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}