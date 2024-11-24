import java.util.*;

class Solution {
    private List<List<Integer>> graph;
    private boolean[] visited;
    private int count;
    
    public int solution(int n, int[][] wires) {
        int minDifference = n;

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];

            graph.get(v1).remove(Integer.valueOf(v2));
            graph.get(v2).remove(Integer.valueOf(v1));

            visited = new boolean[n + 1];
            count = 0;
            dfs(1);
            
            int diff = Math.abs(count - (n - count));
            minDifference = Math.min(minDifference, diff);
            
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
        
        return minDifference;
    }
    
    private void dfs(int node) {
        visited[node] = true;
        count++;
        
        for (int next : graph.get(node)) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}