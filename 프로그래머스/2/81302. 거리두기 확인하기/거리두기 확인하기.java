class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int i = 0; i < 5; i++) {
            char[][] room = new char[5][5];
            for(int j = 0; j < 5; j++) {
                room[j] = places[i][j].toCharArray();
            }
            answer[i] = checkRoom(room);
        }
        
        return answer;
    }
    
    private int checkRoom(char[][] room) {
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(room[i][j] == 'P') {
                    if(!checkPerson(room, i, j)) return 0;
                }
            }
        }
        return 1;
    }
    
    private boolean checkPerson(char[][] room, int row, int col) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        for(int i = 0; i < 4; i++) {
            int nx = row + dx[i];
            int ny = col + dy[i];
            
            if(nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
                if(room[nx][ny] == 'P') return false;
                
                if(room[nx][ny] == 'O') {
                    for(int j = 0; j < 4; j++) {
                        int nnx = nx + dx[j];
                        int nny = ny + dy[j];
                        
                        if(nnx >= 0 && nnx < 5 && nny >= 0 && nny < 5) {
                            if(nnx == row && nny == col) continue;
                            if(room[nnx][nny] == 'P') return false;
                        }
                    }
                }
            }
            
            int nx2 = row + dx[i] * 2;
            int ny2 = col + dy[i] * 2;
            
            if(nx2 >= 0 && nx2 < 5 && ny2 >= 0 && ny2 < 5) {
                if(room[nx2][ny2] == 'P') {
                    if(room[row + dx[i]][col + dy[i]] != 'X') return false;
                }
            }
        }
        
        // 대각선 검사
        int[] dxDiagonal = {-1, -1, 1, 1};
        int[] dyDiagonal = {-1, 1, -1, 1};
        
        for(int i = 0; i < 4; i++) {
            int nx = row + dxDiagonal[i];
            int ny = col + dyDiagonal[i];
            
            if(nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
                if(room[nx][ny] == 'P') {
                    if(room[row][ny] != 'X' || room[nx][col] != 'X') return false;
                }
            }
        }
        
        return true;
    }
}