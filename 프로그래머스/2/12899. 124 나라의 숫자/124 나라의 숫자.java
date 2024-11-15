class Solution {
    public String solution(int n) {
        StringBuilder result = new StringBuilder();
        
        while (n > 0) {
            int remainder = n % 3;
            n = n / 3;
            
            if (remainder == 0) {
                remainder = 4;
                n -= 1;
            }
            
            result.insert(0, remainder);
        }
        
        return result.toString();
    }
}