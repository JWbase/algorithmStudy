import java.util.LinkedList;
import java.util.Queue;

class Solution {
    
    static class State {
        int value;
        int steps;

        public State(int value, int steps) {
            this.value = value;
            this.steps = steps;
        }
    }

    public int solution(int x, int y, int n) {
        Queue<State> queue = new LinkedList<>();
        boolean[] visited = new boolean[y + 1];

        queue.offer(new State(x, 0));
        visited[x] = true;

        while (!queue.isEmpty()) {
            State current = queue.poll();
            
            if (current.value == y) {
                return current.steps;
            }

            int nextValue = current.value + n;
            if (nextValue <= y && !visited[nextValue]) {
                queue.offer(new State(nextValue, current.steps + 1));
                visited[nextValue] = true;
            }

            nextValue = current.value * 2;
            if (nextValue <= y && !visited[nextValue]) {
                queue.offer(new State(nextValue, current.steps + 1));
                visited[nextValue] = true;
            }

            nextValue = current.value * 3;
            if (nextValue <= y && !visited[nextValue]) {
                queue.offer(new State(nextValue, current.steps + 1));
                visited[nextValue] = true;
            }
        }

        return -1;
    }
}