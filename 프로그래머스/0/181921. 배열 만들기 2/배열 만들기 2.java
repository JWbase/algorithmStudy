import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int l, int r) {
        List<Integer> result = new ArrayList<>();
        
        for (int i = l; i <= r; i++) {
            if (isOnlyZeroAndFive(i)) {
                result.add(i);
            }
        }
        
        if (result.isEmpty()) {
            return new int[] { -1 };
        } else {
            return result.stream().mapToInt(Integer::intValue).toArray();
        }
    }
    
    private boolean isOnlyZeroAndFive(int num) {
        String numStr = String.valueOf(num);
        for (int i = 0; i < numStr.length(); i++) {
            if (numStr.charAt(i) != '0' && numStr.charAt(i) != '5') {
                return false;
            }
        }
        return true;
    }
}
