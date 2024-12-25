import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int solution(String[] board) {
        int n = board.length;
        int m = board[0].length();
        int startX = 0, startY = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i].charAt(j) == 'R') {
                    startX = i;
                    startY = j;
                }
            }
        }
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[n][m][4];
        queue.offer(new int[]{startX, startY, 0});
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int count = current[2];
            
            if(board[x].charAt(y) == 'G') {
                return count;
            }
            
            for(int i = 0; i < 4; i++) {
                if(visited[x][y][i]) continue;
                visited[x][y][i] = true;
                
                int nx = x;
                int ny = y;
                
                while(true) {
                    int nextX = nx + dx[i];
                    int nextY = ny + dy[i];
                    
                    if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m || 
                       board[nextX].charAt(nextY) == 'D') {
                        if(nx != x || ny != y) {
                            queue.offer(new int[]{nx, ny, count + 1});
                        }
                        break;
                    }
                    
                    nx = nextX;
                    ny = nextY;
                }
            }
        }
        
        return -1;
    }
}