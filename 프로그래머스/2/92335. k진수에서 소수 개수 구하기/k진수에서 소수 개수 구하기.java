class Solution {
    public int solution(int n, int k) {
        String kBase = Integer.toString(n, k);
        
        String[] candidates = kBase.split("0+");
        
        int count = 0;
        for (String candidate : candidates) {
            if (!candidate.isEmpty() && isPrime(Long.parseLong(candidate))) {
                count++;
            }
        }
        
        return count;
    }
    
    private boolean isPrime(long num) {
        if (num < 2) {
            return false;
        }
        if (num == 2) {
            return true;
        }
        if (num % 2 == 0) {
            return false;
        }
        for (long i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}