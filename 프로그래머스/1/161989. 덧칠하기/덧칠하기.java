class Solution {
    public int solution(int n, int m, int[] section) {
        int count = 0;
        int i = 0;

        while (i < section.length) {
            count++;
            int currentPosition = section[i];
            int maxPosition = currentPosition + m - 1;

            while (i < section.length && section[i] <= maxPosition) {
                i++;
            }
        }

        return count;
    }
}