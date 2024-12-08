class Solution {
    private int getGcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
    
    private int getArrayGcd(int[] array) {
        if (array.length == 1) return array[0];
        
        int gcd = array[0];
        for (int i = 1; i < array.length; i++) {
            gcd = getGcd(gcd, array[i]);
        }
        return gcd;
    }
    
    private boolean canDivideAll(int[] array, int divisor) {
        for (int num : array) {
            if (num % divisor != 0) return false;
        }
        return true;
    }
    
    private boolean cannotDivideAny(int[] array, int divisor) {
        for (int num : array) {
            if (num % divisor == 0) return false;
        }
        return true;
    }
    
    private int findLargestDivisor(int[] array, int[] otherArray) {
        int gcd = getArrayGcd(array);
        int maxDivisor = 0;
        
        for (int i = 1; i * i <= gcd; i++) {
            if (gcd % i == 0) {
                if (canDivideAll(array, i) && cannotDivideAny(otherArray, i)) {
                    maxDivisor = Math.max(maxDivisor, i);
                }
                
                if (i * i != gcd) {
                    int divisor = gcd / i;
                    if (canDivideAll(array, divisor) && cannotDivideAny(otherArray, divisor)) {
                        maxDivisor = Math.max(maxDivisor, divisor);
                    }
                }
            }
        }
        
        return maxDivisor;
    }
    
    public int solution(int[] arrayA, int[] arrayB) {
        int case1 = findLargestDivisor(arrayA, arrayB);
        int case2 = findLargestDivisor(arrayB, arrayA);
        
        return Math.max(case1, case2);
    }
}