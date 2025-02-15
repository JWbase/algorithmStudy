class Solution {
    public int solution(int a, int b) {
        int gcd = getGCD(a, b);
        b /= gcd;
        
        while (b != 1) {
            if (b % 2 == 0) {
                b /= 2;
                continue;
            }
            if (b % 5 == 0) {
                b /= 5;
                continue;
            }
            return 2;
        }
        
        return 1;
    }
    
    private int getGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGCD(b, a % b);
    }
}