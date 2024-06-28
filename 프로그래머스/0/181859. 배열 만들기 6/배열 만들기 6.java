import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int i = 0;
        List<Integer> stk = new ArrayList<>();
        while (i < arr.length) {
            if (stk.size() == 0) {
                stk.add(arr[i]);
                i++;
            } else if(stk.get(stk.size() - 1) == arr[i]) {
                stk.remove(stk.size() - 1);
                i++;
            } else if(stk.get(stk.size() - 1) != arr[i]) {
                stk.add(arr[i]);
                i++;
            }
        }
        
        if (stk.isEmpty()) {
            return new int[] {-1};
        } else {
            return stk.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
