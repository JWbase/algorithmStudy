import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static char[][] map;
    static boolean[][] visited;
    static int N;
    static int dirY[] = {0, 1};
    static int dirX[] = {1, 0};
    static ArrayList<Integer> nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];
        nums = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }

        dfs(0, 0, map[0][0] - '0');

        System.out.println(Collections.max(nums) + " " + Collections.min(nums));
    }

    private static void dfs(int x, int y, int v) {
        if (x == N - 1 && y == N - 1) {
            nums.add(v);
            return;
        }

        visited[x][y] = true;

        for (int i = 0; i < 2; i++) {
            int nowX = x + dirX[i];
            int nowY = y + dirY[i];

            if (nowX >= 0 && nowY >= 0 && nowX < N && nowY < N) {
                if (!visited[nowX][nowY]) {
                    if (map[x][y] == '+') {
                        dfs(nowX, nowY, v + (map[nowX][nowY] - '0'));
                    } else if (map[x][y] == '-') {
                        dfs(nowX, nowY, v - (map[nowX][nowY] - '0'));
                    } else if (map[x][y] == '*') {
                        dfs(nowX, nowY, v * (map[nowX][nowY] - '0'));
                    } else {
                        dfs(nowX, nowY, v);
                    }
                }
            }
        }

        visited[x][y] = false;
    }
}