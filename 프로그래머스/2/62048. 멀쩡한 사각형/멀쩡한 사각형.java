class Solution {
    public long solution(int w, int h) {
        long totalSquares = (long)w * (long)h;
        long unavailableSquares = getUnavailableSquares(w, h);
        return totalSquares - unavailableSquares;
    }
    
    private long getUnavailableSquares(int w, int h) {
        int gcd = getGCD(w, h);
        return (long)w + (long)h - gcd;
    }
    
    private int getGCD(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}