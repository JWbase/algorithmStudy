import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[][] map;
    static ArrayList<Node> teachers;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        teachers = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0, idx = 0; j < N; j++, idx += 2) {
                map[i][j] = str.charAt(idx);
                if (map[i][j] == 'T') {
                    teachers.add(new Node(i, j));
                }
            }
        }
        if (setObstacle(0)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

    static boolean checkObstacle() {
        for (Node teacher : teachers) {
            for (int i = 0; i < 4; i++) {
                int newX = teacher.x;
                int newY = teacher.y;

                while (true) {
                    newX += dx[i];
                    newY += dy[i];

                    if (newX < 0 || newY < 0 || newX >= N || newY >= N) {
                        break;
                    }

                    if (map[newX][newY] == 'S') {
                        return false;
                    } else if (map[newX][newY] == 'O') {
                        break;
                    }
                }
            }
        }
        return true;
    }

    static boolean setObstacle(int count) {
        if (count == 3) {
            if (checkObstacle()) {
                return true;
            } else {
                return false;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'X') {
                    map[i][j] = 'O';
                    if (setObstacle(count + 1)) {
                        return true;
                    }
                    map[i][j] = 'X';
                }
            }
        }
        return false;
    }
}