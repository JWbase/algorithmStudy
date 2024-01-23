import java.util.Scanner;

public class Main {
    private static int N, questions[][], possible;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        questions = new int[N][5];

        for (int i = 0; i < N; i++) {
            questions[i][0] = sc.nextInt();
            questions[i][1] = sc.nextInt();
            questions[i][2] = sc.nextInt();
        }

        for (int i = 123; i <= 987; i++) {
            if (isValidNumber(i) && isPossibleAnswer(i)) possible++;
        }

        System.out.println(possible);
    }

    private static boolean isValidNumber(int num) {
        int hundred = num / 100;
        int ten = (num / 10) % 10;
        int one = num % 10;

        return hundred != ten && hundred != one && ten != one && hundred != 0 && ten != 0 && one != 0;
    }

    private static boolean isPossibleAnswer(int candidate) {
        for (int[] question : questions) {
            int strike = 0, ball = 0;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if ((question[0] / (int) Math.pow(10, 2 - i) % 10) == (candidate / (int) Math.pow(10, 2 - j) % 10)) {
                        if (i == j) strike++;
                        else ball++;
                    }
                }
            }

            if (strike != question[1] || ball != question[2]) return false;
        }
        return true;
    }
}
