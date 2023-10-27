import java.util.*;

/**
 * priorities	location	return [2, 1, 3, 2]	    2	       1
 */
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Program> programs = new LinkedList<>(); // [0, 2] , [1, 1] ...
        for (int i = 0; i < priorities.length; i++) {
            programs.offer(new Program(i, priorities[i]));
        }

        while (!programs.isEmpty()) {
            Program currentQueue = programs.poll();
            for (Program p : programs) {
                if (p.priority > currentQueue.priority) {
                    programs.offer(currentQueue);
                    currentQueue = null;
                    break;
                }
            }
            if (currentQueue != null) {
                answer++;
                if (currentQueue.location == location) {
                    return answer;
                }
            }
        }
        return answer;
    }

    static class Program {
        public int location;
        public int priority;

        public Program(int location, int priority) {
            this.location = location;
            this.priority = priority;
        }
    }
}