import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[][] board;
    static ArrayList<Node> teachers;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Node {
        int x, y;
        Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        teachers = new ArrayList<>();

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0, index = 0; j < N; j++, index += 2){
                board[i][j] = str.charAt(index);
                if(board[i][j] == 'T') teachers.add(new Node(i, j));
            }
        }

        if(setObstacle(0)) System.out.println("YES");
        else System.out.println("NO");
    }

    static boolean setObstacle(int depth){
        if(depth == 3){
            if(check()) return true;
            else return false;
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(board[i][j] == 'X'){
                    board[i][j] = 'O';
                    if(setObstacle(depth + 1)) return true;
                    board[i][j] = 'X';
                }
            }
        }

        return false;
    }

    static boolean check(){
        for(Node teacher : teachers){
            for(int i = 0; i < 4; i++){
                int nx = teacher.x;
                int ny = teacher.y;

                while(true){
                    nx += dx[i];
                    ny += dy[i];

                    if(nx < 0 || ny < 0 || nx >= N || ny >= N) break;

                    if(board[nx][ny] == 'S') return false;
                    else if(board[nx][ny] == 'O') break;
                }
            }
        }

        return true;
    }
}
