class Solution {
    public String solution(int a, int b) {
        int[] daysInMonth = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] dayOfWeek = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        
        int totalDays = b;
        for (int i = 1; i < a; i++) {
            totalDays += daysInMonth[i];
        }

        String answer = dayOfWeek[(totalDays - 1) % 7];
        
        return answer;
    }
}