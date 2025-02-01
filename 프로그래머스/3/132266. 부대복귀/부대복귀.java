import java.util.*;

class Solution {
   public int[] solution(int n, int[][] roads, int[] sources, int destination) {
       List<Integer>[] graph = new ArrayList[n + 1];
       for (int i = 1; i <= n; i++) {
           graph[i] = new ArrayList<>();
       }
       
       for (int[] road : roads) {
           graph[road[0]].add(road[1]);
           graph[road[1]].add(road[0]);
       }
       
       int[] distances = new int[n + 1];
       Arrays.fill(distances, -1);
       Queue<Integer> queue = new LinkedList<>();
       queue.offer(destination);
       distances[destination] = 0;
       
       while (!queue.isEmpty()) {
           int current = queue.poll();
           
           for (int next : graph[current]) {
               if (distances[next] == -1) {
                   distances[next] = distances[current] + 1;
                   queue.offer(next);
               }
           }
       }
       
       int[] result = new int[sources.length];
       for (int i = 0; i < sources.length; i++) {
           result[i] = distances[sources[i]];
       }
       
       return result;
   }
}