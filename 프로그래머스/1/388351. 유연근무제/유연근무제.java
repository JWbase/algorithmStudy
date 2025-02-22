class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        for (int i = 0; i < schedules.length; i++) {
            int sch = schedules[i];
            int h = sch / 100;
            int m = sch % 100 + 10;
            if (m >= 60) {
                h++;
                m -= 60;
            }
            int deadline = h * 100 + m;
            boolean ok = true;
            for (int j = 0; j < 7; j++) {
                int day = (startday + j - 1) % 7 + 1;
                if (day <= 5) {
                    if (timelogs[i][j] > deadline) {
                        ok = false;
                        break;
                    }
                }
            }
            if (ok) answer++;
        }
        return answer;
    }
}