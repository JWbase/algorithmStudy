class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int n = sequence.length;
        
        int left = 0;
        int right = 0;
        int sum = sequence[0];
        int minLength = n + 1;
        
        while (right < n) {
            if (sum == k) {
                int currentLength = right - left + 1;
                if (currentLength < minLength) {
                    minLength = currentLength;
                    answer[0] = left;
                    answer[1] = right;
                }
                sum -= sequence[left];
                left++;
            }
            else if (sum < k) {
                right++;
                if (right < n) {
                    sum += sequence[right];
                }
            }
            else {
                sum -= sequence[left];
                left++;
            }
        }
        
        return answer;
    }
}