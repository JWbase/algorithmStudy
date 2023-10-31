class Solution {
    public int solution(int[][] arr) {
        int answer = 0;
        int flag = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[i][j] != arr[j][i]) {
                    flag++;
                }
            }
        }
        if(flag == 0) {
            return 1;
        }
        return 0;
    }
}