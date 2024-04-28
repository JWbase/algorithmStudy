import java.util.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        ArrayList<Integer> result = new ArrayList<>();
        
        for (String str : intStrs) {
            int num = Integer.parseInt(str.substring(s, s + l));
            
            if (num > k) {
                result.add(num);
            }
        }
        
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        
        return resultArray;
    }
}