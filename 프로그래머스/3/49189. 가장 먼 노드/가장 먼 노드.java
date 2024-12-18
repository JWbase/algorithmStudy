import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        int[] distances = new int[n + 1];
        Arrays.fill(distances, -1);
        distances[1] = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int next : graph.get(current)) {
                if (distances[next] == -1) {
                    distances[next] = distances[current] + 1;
                    queue.offer(next);
                }
            }
        }
        
        int maxDistance = 0;
        int count = 0;
        
        for (int i = 2; i <= n; i++) {
            if (distances[i] > maxDistance) {
                maxDistance = distances[i];
                count = 1;
            } else if (distances[i] == maxDistance) {
                count++;
            }
        }
        
        return count;
    }
}