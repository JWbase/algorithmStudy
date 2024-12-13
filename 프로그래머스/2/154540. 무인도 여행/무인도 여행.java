import java.util.*;

class Solution {
    private int rows;
    private int cols;
    private boolean[][] visited;
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public int[] solution(String[] maps) {
        rows = maps.length;
        cols = maps[0].length();
        visited = new boolean[rows][cols];
        List<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && maps[i].charAt(j) != 'X') {
                    answer.add(dfs(maps, i, j));
                }
            }
        }
        
        if (answer.isEmpty()) {
            return new int[]{-1};
        }
        
        Collections.sort(answer);
        return answer.stream().mapToInt(i -> i).toArray();
    }
    
    private int dfs(String[] maps, int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || 
            visited[row][col] || maps[row].charAt(col) == 'X') {
            return 0;
        }
        
        visited[row][col] = true;
        
        int sum = maps[row].charAt(col) - '0';
        
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            sum += dfs(maps, newRow, newCol);
        }
        
        return sum;
    }
}