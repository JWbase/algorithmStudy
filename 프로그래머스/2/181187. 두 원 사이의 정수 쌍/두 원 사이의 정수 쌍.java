class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        long r1Squared = (long) r1 * r1;
        long r2Squared = (long) r2 * r2;
        
        for (int x = 1; x <= r2; x++) {
            long xSquared = (long) x * x;
            int yMaxForR2 = (int) Math.floor(Math.sqrt(r2Squared - xSquared));
            int yMinForR1 = (x <= r1) ? (int) Math.ceil(Math.sqrt(r1Squared - xSquared)) : 0;
            
            answer += (yMaxForR2 - yMinForR1 + 1);
        }
        
        answer *= 4;
        
        return answer;
    }
}