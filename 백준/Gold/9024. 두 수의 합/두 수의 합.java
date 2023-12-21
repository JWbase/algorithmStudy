import java.io.*;
import java.util.*;

public class Main {

    static int T, n, K, ans;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            ans = 0;
            int left = 0, right = n - 1;
            int minDiff = Integer.MAX_VALUE;

            while (left < right) {
                int sum = arr[left] + arr[right];
                int diff = Math.abs(K - sum);

                if (diff < minDiff) {
                    minDiff = diff;
                    ans = 1;
                } else if (diff == minDiff) {
                    ans++;
                }

                if (sum < K) {
                    left++;
                } else {
                    right--;
                }
            }
            System.out.println(ans);
        }
    }
}
