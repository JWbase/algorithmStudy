import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        Arrays.sort(mats);
        
        int rows = park.length;
        int cols = park[0].length;
        
        for (int i = mats.length - 1; i >= 0; i--) {
            int size = mats[i];
            
            for (int r = 0; r <= rows - size; r++) {
                for (int c = 0; c <= cols - size; c++) {
                    if (canPlaceMat(park, r, c, size)) {
                        return size;
                    }
                }
            }
        }
        
        return -1;
    }
    
    private boolean canPlaceMat(String[][] park, int startRow, int startCol, int size) {
        for (int r = startRow; r < startRow + size; r++) {
            for (int c = startCol; c < startCol + size; c++) {
                if (!park[r][c].equals("-1")) {
                    return false;
                }
            }
        }
        return true;
    }
}