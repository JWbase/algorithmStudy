import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int M, N;
    static int[] snack;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        snack = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        int max = 0;
        for (int i = 0; i < N; i++) {
            snack[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, snack[i]);
        }

        long start = 1;
        long end = max;
        long result = 0;

        while (start <= end) {
            long mid = (start + end) / 2;
            long total = 0;
            for (int i = 0; i < N; i++) {
                total += snack[i] / mid;
            }

            if (total >= M) {
                start = mid + 1;
                result = Math.max(result, mid);
            } else {
                end = mid - 1;
            }
        }

        System.out.println(result);
    }
}
