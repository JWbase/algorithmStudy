class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        
        // 전체를 순회하며 다음번 값이 오르는 경우를 찾는다.
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                result += prices[i + 1] - prices[i];
            }
        }
        return result;
    }
}