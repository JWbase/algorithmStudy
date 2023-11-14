import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int INF = -1;

    public static void main(String[] args) throws Exception{
        new Main().solution();
    }

    private void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        List<Integer>[] edges = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[a].add(b);
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        dist[x] = 0;

        List<Integer> answer = new ArrayList<>();

        while (!q.isEmpty()) {
            int current = q.poll();
            if (dist[current] > k) {
                break;
            }
            if (dist[current] == k) {
                answer.add(current);
            }

            for (int next : edges[current]) {
                if (dist[next] != INF) continue;
                dist[next] = dist[current] + 1;
                q.offer(next);
            }
        }


        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        for (int cur : answer) {
            sb.append(cur).append('\n');
        }
        System.out.print(answer.isEmpty() ? -1 : sb);
    }
}