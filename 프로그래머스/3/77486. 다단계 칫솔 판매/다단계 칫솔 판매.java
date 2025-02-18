import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, String> parentMap = new HashMap<>();
        Map<String, Integer> indexMap = new HashMap<>();
        int[] result = new int[enroll.length];
        
        for (int i = 0; i < enroll.length; i++) {
            parentMap.put(enroll[i], referral[i]);
            indexMap.put(enroll[i], i);
        }
        
        for (int i = 0; i < seller.length; i++) {
            String currentSeller = seller[i];
            int profit = amount[i] * 100;
            
            while (!currentSeller.equals("-") && profit > 0) {
                int distribute = profit / 10;
                int keep = profit - distribute;
                
                if (indexMap.containsKey(currentSeller)) {
                    result[indexMap.get(currentSeller)] += keep;
                }
                
                profit = distribute;
                currentSeller = parentMap.get(currentSeller);
            }
        }
        
        return result;
    }
}