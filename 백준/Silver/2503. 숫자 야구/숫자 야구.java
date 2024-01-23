import java.util.Scanner;

public class Main {
    static int N, question[][], possible;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        question = new int[N][5];
        for (int i = 0; i < N; i++) {
            question[i][0] = sc.nextInt();
            question[i][1] = sc.nextInt();
            question[i][2] = sc.nextInt();
        }

        for (int i = 123; i <= 987; i++) {
            int hundred = i / 100;
            int ten = (i / 10) % 10;
            int one = i % 10;

            if (hundred == ten || hundred == one || ten == one) continue;
            if (hundred == 0 || ten == 0 || one == 0) continue;

            if (isPossible(i)) possible++;
        }

        System.out.println(possible);
    }

    static boolean isPossible(int candidate) {
        for (int i = 0; i < N; i++) {
            int strike = 0, ball = 0;
            int qHundred = question[i][0] / 100;
            int qTen = (question[i][0] / 10) % 10;
            int qOne = question[i][0] % 10;

            int cHundred = candidate / 100;
            int cTen = (candidate / 10) % 10;
            int cOne = candidate % 10;

            if (qHundred == cHundred) strike++;
            if (qTen == cTen) strike++;
            if (qOne == cOne) strike++;

            if (qHundred == cTen || qHundred == cOne) ball++;
            if (qTen == cHundred || qTen == cOne) ball++;
            if (qOne == cHundred || qOne == cTen) ball++;

            if (strike != question[i][1] || ball != question[i][2]) return false;
        }
        return true;
    }
}
