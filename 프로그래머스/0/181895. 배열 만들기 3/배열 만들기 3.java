class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        int firstLength = intervals[0][1] - intervals[0][0] + 1;
        int secondLength = intervals[1][1] - intervals[1][0] + 1;
        int[] result = new int[firstLength + secondLength];
        for (int i = 0; i < firstLength; i++) {
            result[i] = arr[intervals[0][0] + i];
        }
        for (int i = 0; i < secondLength; i++) {
            result[firstLength + i] = arr[intervals[1][0] + i];
        }
        
        return result;
    }
}