import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] hp = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            hp[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] happy = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            happy[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[101];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 99; j >= 0; j--) {
                int energy = hp[i] + j;
                if (energy < 100) {
                    dp[energy] = Math.max(dp[energy], dp[j] + happy[i]);
                }
            }
        }
        
        System.out.println(dp[99]);
    }
}
