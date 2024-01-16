import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] subjects = new long[N];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 1; j < input.length; j++) {
                int t = Integer.parseInt(input[j]) - 1;
                subjects[i] |= (1L << t);
            }
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            long student = 0;
            for (int j = 1; j < input.length; j++) {
                int q = Integer.parseInt(input[j]) - 1;
                student |= (1L << q);
            }

            int count = 0;
            for (long subject : subjects) {
                if ((student & subject) == subject) count++;
            }

            System.out.println(count);
        }
    }
}
