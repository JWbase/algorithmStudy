import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        int rowSize = relation.length;
        int colSize = relation[0].length;
        
        List<Integer> candidateKeys = new ArrayList<>();
        
        for (int i = 1; i < (1 << colSize); i++) {
            if (!isMinimal(i, candidateKeys)) {
                continue;
            }
            
            if (isUnique(i, rowSize, colSize, relation)) {
                candidateKeys.add(i);
            }
        }
        
        return candidateKeys.size();
    }
    
    private boolean isMinimal(int key, List<Integer> candidateKeys) {
        for (int candidateKey : candidateKeys) {
            if ((key & candidateKey) == candidateKey) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isUnique(int key, int rowSize, int colSize, String[][] relation) {
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < rowSize; i++) {
            StringBuilder sb = new StringBuilder();
            
            for (int j = 0; j < colSize; j++) {
                if ((key & (1 << j)) != 0) {
                    sb.append(relation[i][j]).append(",");
                }
            }
            
            if (!set.add(sb.toString())) {
                return false;
            }
        }
        
        return true;
    }
}