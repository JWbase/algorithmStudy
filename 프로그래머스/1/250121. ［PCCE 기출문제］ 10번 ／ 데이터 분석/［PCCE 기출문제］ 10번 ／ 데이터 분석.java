import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        Map<String, Integer> columnMap = new HashMap<>();
        columnMap.put("code", 0);
        columnMap.put("date", 1);
        columnMap.put("maximum", 2);
        columnMap.put("remain", 3);
        
        int filterIdx = columnMap.get(ext);
        int sortIdx = columnMap.get(sort_by);
        
        List<int[]> filteredList = new ArrayList<>();
        for (int[] row : data) {
            if (row[filterIdx] < val_ext) {
                filteredList.add(row);
            }
        }
        
        Collections.sort(filteredList, (a, b) -> {
            return Integer.compare(a[sortIdx], b[sortIdx]);
        });
        
        return filteredList.toArray(new int[filteredList.size()][]);
    }
}