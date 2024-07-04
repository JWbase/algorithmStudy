class Solution {
    public int[][] solution(int[][] arr) {
        int rows = arr.length;
    int cols = arr[0].length;
    
    // 행의 수가 더 많은 경우
    if (rows > cols) {
        int[][] result = new int[rows][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = arr[i][j];
            }
            for (int j = cols; j < rows; j++) {
                result[i][j] = 0;
            }
        }
        return result;
    }
    // 열의 수가 더 많은 경우
    else if (cols > rows) {
        int[][] result = new int[cols][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = arr[i][j];
            }
        }
        for (int i = rows; i < cols; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = 0;
            }
        }
        return result;
    }
    // 행과 열의 수가 같은 경우
    else {
        return arr;
    }
    }
}