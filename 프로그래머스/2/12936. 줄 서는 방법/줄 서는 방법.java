class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        boolean[] used = new boolean[n + 1];
        k = k - 1;
        
        for (int i = 0; i < n; i++) {
            long factorial = factorial(n - i - 1);
            int count = 1;
            for (int j = 1; j <= n; j++) {
                if (!used[j]) {
                    if (k >= factorial) {
                        k -= factorial;
                    } else {
                        answer[i] = j;
                        used[j] = true;
                        break;
                    }
                    count++;
                }
            }
        }
        
        return answer;
    }
    
    private long factorial(int n) {
        if (n <= 1) return 1;
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}