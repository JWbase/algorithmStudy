class Solution {
    public int[] solution(long begin, long end) {
        int length = (int)(end - begin + 1);
        int[] result = new int[length];
        
        for (int i = 0; i < length; i++) {
            long position = begin + i;
            
            if (position == 1) {
                result[i] = 0;
                continue;
            }
            
            result[i] = 1;
            
            for (int j = 2; j <= Math.sqrt(position); j++) {
                if (position % j == 0) {
                    if (position / j <= 10000000) {
                        result[i] = (int)(position / j);
                        break;
                    } else {
                        result[i] = j;
                    }
                }
            }
        }
        
        return result;
    }
}