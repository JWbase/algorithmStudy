import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] arr = new int[N][M];

        for(int i=0; i<N; i++){
            String str = sc.next();
            for(int j=0; j<M; j++){
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        int min = Math.min(N, M);
        int maxArea = 0;

        loop: for(int len=min; len>0; len--){
            for(int i=0; i<=N-len; i++){
                for(int j=0; j<=M-len; j++){
                    if(arr[i][j] == arr[i+len-1][j] && arr[i][j] == arr[i][j+len-1] && arr[i][j] == arr[i+len-1][j+len-1]){
                        maxArea = len;
                        break loop;
                    }
                }
            }
        }
        System.out.println(maxArea*maxArea);
    }
}
