import java.util.Arrays;

class Solution {
    public int solution(int[] stones, int k) {
        int left = 1;
        int right = 200000000;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (canCross(stones, k, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return right;
    }
    
    private boolean canCross(int[] stones, int k, int friends) {
        int[] temp = stones.clone();
        
        for (int i = 0; i < temp.length; i++) {
            temp[i] -= friends - 1;
        }
        
        int zeros = 0;
        for (int stone : temp) {
            if (stone <= 0) {
                zeros++;
            } else {
                zeros = 0;
            }
            
            if (zeros == k) {
                return false;
            }
        }
        
        return true;
    }
}