import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int n = cards.length;
        
        int[] groups = new int[n];
        Arrays.fill(groups, -1);
        
        List<Integer> groupSizes = new ArrayList<>();
        
        int groupId = 0;
        for (int i = 0; i < n; i++) {
            if (groups[i] == -1) {
                int count = 0;
                int current = i;
                
                while (groups[current] == -1) {
                    groups[current] = groupId;
                    count++;
                    current = cards[current] - 1;
                }
                
                if (count > 0) {
                    groupSizes.add(count);
                    groupId++;
                }
            }
        }
        
        if (groupSizes.size() <= 1) {
            return 0;
        }
        
        Collections.sort(groupSizes, Collections.reverseOrder());
        
        return groupSizes.get(0) * groupSizes.get(1);
    }
}