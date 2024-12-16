import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int solution(String[] maps) {
        int[] start = null;
        int[] lever = null;
        int[] end = null;
        
        int n = maps.length;
        int m = maps[0].length();
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                char c = maps[i].charAt(j);
                if(c == 'S') start = new int[]{i, j};
                else if(c == 'L') lever = new int[]{i, j};
                else if(c == 'E') end = new int[]{i, j};
            }
        }

        int startToLever = bfs(maps, start, lever);
        if(startToLever == -1) return -1;
        
        int leverToEnd = bfs(maps, lever, end);
        if(leverToEnd == -1) return -1;
        
        return startToLever + leverToEnd;
    }
    
    private int bfs(String[] maps, int[] start, int[] end) {
        int n = maps.length;
        int m = maps[0].length();
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];

            if(x == end[0] && y == end[1]) {
                return distance;
            }

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx >= 0 && nx < n && ny >= 0 && ny < m 
                   && !visited[nx][ny] && maps[nx].charAt(ny) != 'X') {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, distance + 1});
                }
            }
        }
        
        return -1;
    }
}