import java.util.*;

class Solution {
    private final int[] dx = {-1, 0, 1, 0};
    private final int[] dy = {0, 1, 0, -1};
    private final int STRAIGHT_COST = 100;
    private final int CORNER_COST = 500;
    
    public int solution(int[][] board) {
        int n = board.length;
        int[][][] cost = new int[n][n][4];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    cost[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        
        cost[0][0][1] = 0;
        cost[0][0][2] = 0;
        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(0, 0, 1, 0));
        queue.add(new Node(0, 0, 2, 0));
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            
            if (current.cost > cost[current.y][current.x][current.dir]) {
                continue;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= n || ny >= n || board[ny][nx] == 1) {
                    continue;
                }
                
                int newCost = current.cost + STRAIGHT_COST;
                
                if (current.dir != i) {
                    newCost += CORNER_COST;
                }
                
                if (newCost < cost[ny][nx][i]) {
                    cost[ny][nx][i] = newCost;
                    queue.add(new Node(nx, ny, i, newCost));
                }
            }
        }
        
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            minCost = Math.min(minCost, cost[n-1][n-1][i]);
        }
        
        return minCost;
    }
    

    private static class Node implements Comparable<Node> {
        int x, y;
        int dir;
        int cost;
        
        public Node(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node other) {
            return this.cost - other.cost;
        }
    }
}