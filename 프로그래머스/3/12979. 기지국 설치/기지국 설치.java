class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int position = 1;
        int stationIndex = 0;
        
        while (position <= n) {
            if (stationIndex < stations.length && position >= stations[stationIndex] - w) {
                position = stations[stationIndex] + w + 1;
                stationIndex++;
            }
            else {
                answer++;
                position += 2 * w + 1;
            }
        }
        
        return answer;
    }
}