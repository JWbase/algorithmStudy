class Solution {
    public int solution(String word) {
        char[] vowels = {'A', 'E', 'I', 'O', 'U'};
        int[] dp = {781, 156, 31, 6, 1};
        int result = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            for (int j = 0; j < vowels.length; j++) {
                if (c == vowels[j]) {
                    result += dp[i] * j + 1;
                    break;
                }
            }
        }
        
        return result;
    }
}