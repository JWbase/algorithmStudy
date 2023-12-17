import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[] arr;
    private static int[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        visited = new int[100001];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long answer = 0;
        int start = 1, end = 1;

        while (start <= N && end <= N) {
            if (visited[arr[end]] == 0) {
                visited[arr[end]] = 1;
                answer += (end - start + 1);
                end++;
            } else {
                visited[arr[start]] = 0;
                start++;
            }
        }

        System.out.println(answer);
    }
}
