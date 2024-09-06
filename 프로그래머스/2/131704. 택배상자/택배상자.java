import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        int box = 1;
        int count = 0;
        
        while (box <= order.length) {
            if (box == order[index]) {
                count++;
                index++;
                box++;
            } else if (!stack.isEmpty() && stack.peek() == order[index]) {
                stack.pop();
                count++;
                index++;
            } else {
                stack.push(box);
                box++;
            }
        }
        
        while (!stack.isEmpty() && stack.peek() == order[index]) {
            stack.pop();
            count++;
            index++;
        }
        
        return count;
    }
}