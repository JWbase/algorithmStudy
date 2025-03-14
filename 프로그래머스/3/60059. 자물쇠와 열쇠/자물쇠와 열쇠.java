class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int M = key.length;
        int N = lock.length;
        
        int lockHoleCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (lock[i][j] == 0) {
                    lockHoleCount++;
                }
            }
        }
        
        if (lockHoleCount == 0) {
            return true;
        }
        
        for (int rotation = 0; rotation < 4; rotation++) {
            key = rotateKey(key);
            
            for (int offsetX = -(M-1); offsetX < N; offsetX++) {
                for (int offsetY = -(M-1); offsetY < N; offsetY++) {
                    if (canUnlock(key, lock, offsetX, offsetY, lockHoleCount)) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    private int[][] rotateKey(int[][] key) {
        int M = key.length;
        int[][] rotated = new int[M][M];
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                rotated[j][M-1-i] = key[i][j];
            }
        }
        
        return rotated;
    }
    
    private boolean canUnlock(int[][] key, int[][] lock, int offsetX, int offsetY, int lockHoleCount) {
        int M = key.length;
        int N = lock.length;
        int filledHoles = 0;
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                int lockX = i + offsetX;
                int lockY = j + offsetY;
                
                if (lockX >= 0 && lockX < N && lockY >= 0 && lockY < N) {
                    if (key[i][j] == 1 && lock[lockX][lockY] == 1) {
                        return false;
                    }
                    
                    if (key[i][j] == 1 && lock[lockX][lockY] == 0) {
                        filledHoles++;
                    }
                }
            }
        }
        
        return filledHoles == lockHoleCount;
    }
}