import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        
        HashSet<Integer> deleteSet = new HashSet();
        ArrayList<Integer> list = new ArrayList();
        
        for (int d : delete_list) {
            deleteSet.add(d);
        }
        
        for (int a : arr) {
            if(!deleteSet.contains(a)) {
                list.add(a);
            }
        }
        
        return list.stream()
            .mapToInt(i -> i)
            .toArray();
    }
}