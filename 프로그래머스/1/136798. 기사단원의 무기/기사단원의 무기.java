class Solution {
    public int solution(int number, int limit, int power) {
        
        int[] divisorCount = new int[number + 1];
        int answer = 0;
        
        for (int i = 1; i <= number; i++) {
            for (int j = i; j <= number; j += i) {
                divisorCount[j]++;
            }
        }
        
        for (int i = 1; i <= number; i++) {
            int weaponPower = divisorCount[i];
            if (weaponPower > limit) {
                answer += power;
            } else {
                answer += weaponPower;
            }
        }
        
        return answer;
    }
}