import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        HashSet<Integer> seen = new HashSet<>();
        
        for (int num : arr) {
            if (!seen.contains(num)) {
                seen.add(num);
                result.add(num);
                if (result.size() == k) {
                    return result.stream().mapToInt(i -> i).toArray();
                }
            }
        }
        
        while (result.size() < k) {
            result.add(-1);
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}