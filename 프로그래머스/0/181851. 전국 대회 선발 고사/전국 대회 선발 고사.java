import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        List<Integer> attendanceList = new ArrayList<>();
        for (int i = 0; i < attendance.length; i++) {
            if (attendance[i]) {
                attendanceList.add(i);
            }
        }
        
        Collections.sort(attendanceList, (a, b) -> rank[a] - rank[b]);
        
        int a = attendanceList.get(0);
        int b = attendanceList.get(1);
        int c = attendanceList.get(2);
        
        return 10000 * a + 100 * b + c;
    }
}