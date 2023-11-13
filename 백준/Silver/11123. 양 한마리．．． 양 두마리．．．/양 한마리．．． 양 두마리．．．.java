import java.util.*;
import java.io.*;

public class Main {
    static int rowSize, colSize, count;
    static char[][] map;
    static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < testCases; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            rowSize = Integer.parseInt(st.nextToken());
            colSize = Integer.parseInt(st.nextToken());
            map = new char[rowSize][colSize];

            for (int i = 0; i < rowSize; i++) {
                map[i] = br.readLine().toCharArray();
            }

            count = 0;
            for (int i = 0; i < rowSize; i++) {
                for (int j = 0; j < colSize; j++) {
                    if (map[i][j] == '#') {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    static void dfs(int row, int col) {
        map[row][col] = '.';

        for (int[] direction : DIRECTIONS) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if (isValid(newRow, newCol) && map[newRow][newCol] == '#') {
                dfs(newRow, newCol);
            }
        }
    }

    static boolean isValid(int row, int col) {
        return row >= 0 && row < rowSize && col >= 0 && col < colSize;
    }
}
