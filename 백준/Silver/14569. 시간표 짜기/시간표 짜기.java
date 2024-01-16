import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        boolean[][] subjects = new boolean[N][51];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            int k = Integer.parseInt(line[0]);
            for (int j = 1; j <= k; j++) {
                int t = Integer.parseInt(line[j]);
                subjects[i][t] = true;
            }
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String[] line = br.readLine().split(" ");
            int p = Integer.parseInt(line[0]);
            boolean[] student = new boolean[51];
            for (int j = 1; j <= p; j++) {
                int q = Integer.parseInt(line[j]);
                student[q] = true;
            }

            int count = 0;
            for (int j = 0; j < N; j++) {
                boolean canTake = true;
                for (int k = 1; k <= 50; k++) {
                    if (subjects[j][k] && !student[k]) {
                        canTake = false;
                        break;
                    }
                }
                if (canTake) count++;
            }

            System.out.println(count);
        }
    }
}
