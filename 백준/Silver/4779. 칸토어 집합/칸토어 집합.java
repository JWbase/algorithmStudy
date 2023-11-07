import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            String cantorSet = createCantorSet(n);
            System.out.println(cantorSet);
        }
        scanner.close();
    }

    private static String createCantorSet(int n) {
        if (n == 0) {
            return "-";
        }
        String previousSet = createCantorSet(n - 1);
        String space = String.format("%" + previousSet.length() + "s", " ");
        return previousSet + space + previousSet;
    }
}
