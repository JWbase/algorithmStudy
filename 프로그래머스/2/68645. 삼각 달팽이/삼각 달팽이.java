class Solution {
    public int[] solution(int n) {
        int[][] triangle = new int[n][n];
        int value = 1;
        int x = 0, y = 0;
        
        int total = n * (n + 1) / 2;
        int[] answer = new int[total];
        
        int[] dx = {1, 0, -1};
        int[] dy = {0, 1, -1};
        int direction = 0;
        
        while(value <= total) {
            triangle[x][y] = value++;
            
            int nx = x + dx[direction];
            int ny = y + dy[direction];
            
            if(nx < 0 || nx >= n || ny < 0 || ny >= n || triangle[nx][ny] != 0) {
                direction = (direction + 1) % 3;
                nx = x + dx[direction];
                ny = y + dy[direction];
            }
            
            x = nx;
            y = ny;
        }
        
        int index = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                answer[index++] = triangle[i][j];
            }
        }
        
        return answer;
    }
}