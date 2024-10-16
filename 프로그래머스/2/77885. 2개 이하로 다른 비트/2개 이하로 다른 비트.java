import java.util.Arrays;

class Solution {
    public long[] solution(long[] numbers) {
        long[] result = new long[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            long x = numbers[i];
            if (x % 2 == 0) {
                result[i] = x + 1;
            } 
            else {
                long bitMask = 1;
                while ((x & bitMask) == bitMask) {
                    bitMask <<= 1;
                }
                result[i] = (x | bitMask) & ~(bitMask >> 1);
            }
        }
        
        return result;
    }
}