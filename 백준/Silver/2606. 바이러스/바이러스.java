import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] graph;
    static boolean[] visited;
    static int M, N;
    static int answer;

    static void dfs(int idx) {
        visited[idx] = true;
        answer++;

        for (int i = 1; i <= M; i++) {
            if (!visited[i] && graph[idx][i]) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        M = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        graph = new boolean[M + 1][M + 1];
        visited = new boolean[M + 1];

        int x, y;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            graph[x][y] = true;
            graph[y][x] = true;
        }
        dfs(1);

        bw.write(String.valueOf(answer - 1));
        br.close();
        bw.close();
    }
}