class Solution {
    public int solution(int[][] board) {
        int n = board.length;
        boolean[][] dangerZone = new boolean[n][n];

        // 지뢰가 있는 위치와 그 주변을 위험 지역으로 표시
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    // 현재 지뢰가 있는 위치
                    dangerZone[i][j] = true; // 지뢰 위치
                    // 주변 8칸을 위험 지역으로 설정
                    markDangerZone(dangerZone, i, j, n);
                }
            }
        }

        // 안전 지역의 수를 계산
        int safeCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!dangerZone[i][j]) {
                    safeCount++;
                }
            }
        }

        return safeCount;
    }

    private static void markDangerZone(boolean[][] dangerZone, int x, int y, int n) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newX = x + i;
                int newY = y + j;
                // 범위를 벗어나지 않도록 체크
                if (newX >= 0 && newX < n && newY >= 0 && newY < n) {
                    dangerZone[newX][newY] = true;
                }
            }
        }
    }
}