import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int total = picks[0] + picks[1] + picks[2];
        int len = Math.min(total * 5, minerals.length);
        int[][] section = new int[(len + 4) / 5][3];
        
        for (int i = 0; i < len; i++) {
            if (minerals[i].equals("diamond")) {
                section[i / 5][0] += 1;
                section[i / 5][1] += 5;
                section[i / 5][2] += 25;
            } else if (minerals[i].equals("iron")) {
                section[i / 5][0] += 1;
                section[i / 5][1] += 1;
                section[i / 5][2] += 5;
            } else {
                section[i / 5][0] += 1;
                section[i / 5][1] += 1;
                section[i / 5][2] += 1;
            }
        }
        
        int answer = 0;
        int[][] sorted = new int[section.length][4];
        
        for (int i = 0; i < section.length; i++) {
            sorted[i][0] = section[i][2];
            sorted[i][1] = section[i][0];
            sorted[i][2] = section[i][1];
            sorted[i][3] = section[i][2];
        }
        
        Arrays.sort(sorted, (a, b) -> b[0] - a[0]);
        
        int pickIdx = 0;
        for (int i = 0; i < sorted.length; i++) {
            while (pickIdx < 3 && picks[pickIdx] == 0) {
                pickIdx++;
            }
            if (pickIdx == 3) break;
            
            answer += sorted[i][pickIdx + 1];
            picks[pickIdx]--;
        }
        
        return answer;
    }
}