class Solution {
    public int solution(int[][] lines) {
        int[] lineCounts = new int[201];
        
        for (int[] line : lines) {
            int start = line[0] + 100;
            int end = line[1] + 100;
            
            for (int i = start; i < end; i++) {
                lineCounts[i]++;
            }
        }
        
        int overlapLength = 0;
        for (int count : lineCounts) {
            if (count > 1) {
                overlapLength++;
            }
        }
        
        return overlapLength;
    }
}