import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Printer> printQueue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            printQueue.offer(new Printer(i, priorities[i]));
        }

        int answer = 1;

        while (!printQueue.isEmpty()) {
            Printer current = printQueue.poll();
            boolean isMax = printQueue.stream().noneMatch(printer -> printer.priority > current.priority);

            if (isMax) {
                if (current.location == location) {
                    break;
                }
                answer++;
            } else {
                printQueue.offer(current);
            }
        }

        return answer;
    }
}

class Printer {
    int location;
    int priority;

    public Printer(int location, int priority) {
        this.location = location;
        this.priority = priority;
    }
}