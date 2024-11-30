import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int[][] graph = new int[N + 1][N + 1];
        
        for (int i = 1; i <= N; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
            graph[i][i] = 0;
        }
        
        for (int[] r : road) {
            int a = r[0], b = r[1], c = r[2];
            graph[a][b] = Math.min(graph[a][b], c);
            graph[b][a] = Math.min(graph[b][a], c);
        }
        
        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;
        
        boolean[] visited = new boolean[N + 1];
        
        for (int i = 1; i <= N; i++) {
            int minDist = Integer.MAX_VALUE;
            int current = 0;
            
            for (int j = 1; j <= N; j++) {
                if (!visited[j] && distance[j] < minDist) {
                    minDist = distance[j];
                    current = j;
                }
            }
            
            visited[current] = true;
            
            for (int j = 1; j <= N; j++) {
                if (!visited[j] && graph[current][j] != Integer.MAX_VALUE) {
                    distance[j] = Math.min(distance[j], 
                                        distance[current] + graph[current][j]);
                }
            }
        }
        
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (distance[i] <= K) {
                count++;
            }
        }
        
        return count;
    }
}