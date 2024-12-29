import java.util.*;

class Solution {
    static class Node {
        int x;
        int y;
        int cost;
        
        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
    
    static int[] parent;
    
    public int solution(int n, int[][] costs) {
        parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        for(int[] cost : costs) {
            pq.add(new Node(cost[0], cost[1], cost[2]));
        }
        
        int total = 0;
        while(!pq.isEmpty()) {
            Node current = pq.poll();
            
            if(find(current.x) != find(current.y)) {
                union(current.x, current.y);
                total += current.cost;
            }
        }
        
        return total;
    }
    
    static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    static void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        
        if(px != py) {
            parent[py] = px;
        }
    }
}