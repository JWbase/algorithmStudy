import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] visited = new boolean[29][29];
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static double[] rates = new double[4];
    static int N;
    static double answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 4; i++) {
            rates[i] = 0.01 * Integer.parseInt(st.nextToken());
        }

        dfs(14, 14, 0, 1.0);
        System.out.println(answer);
    }

    private static void dfs(int x, int y, int count, double rate) {
        if (visited[x][y]) {
            return;
        }
        if (count == N) {
            answer += rate;
            return;
        }
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            dfs(newX, newY, count + 1, rate * rates[i]);
        }
        visited[x][y] = false;
    }
}
