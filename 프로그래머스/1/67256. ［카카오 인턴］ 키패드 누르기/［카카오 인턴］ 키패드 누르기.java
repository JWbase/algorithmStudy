import java.util.*;

class Solution {
    private static final int[][] KEYPAD_POSITIONS = {
        {3, 1},
        {0, 0},
        {0, 1},
        {0, 2},
        {1, 0},
        {1, 1},
        {1, 2},
        {2, 0},
        {2, 1},
        {2, 2}
    };
    
    public String solution(int[] numbers, String hand) {
        int[] leftPos = {3, 0};
        int[] rightPos = {3, 2};
        StringBuilder result = new StringBuilder();

        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                result.append("L");
                leftPos = KEYPAD_POSITIONS[number];
            } else if (number == 3 || number == 6 || number == 9) {
                result.append("R");
                rightPos = KEYPAD_POSITIONS[number];
            } else {
                int leftDistance = getDistance(leftPos, KEYPAD_POSITIONS[number]);
                int rightDistance = getDistance(rightPos, KEYPAD_POSITIONS[number]);

                if (leftDistance < rightDistance) {
                    result.append("L");
                    leftPos = KEYPAD_POSITIONS[number];
                } else if (rightDistance < leftDistance) {
                    result.append("R");
                    rightPos = KEYPAD_POSITIONS[number];
                } else {
                    if (hand.equals("right")) {
                        result.append("R");
                        rightPos = KEYPAD_POSITIONS[number];
                    } else {
                        result.append("L");
                        leftPos = KEYPAD_POSITIONS[number];
                    }
                }
            }
        }
        return result.toString();
    }

    private static int getDistance(int[] pos1, int[] pos2) {
        return Math.abs(pos1[0] - pos2[0]) + Math.abs(pos1[1] - pos2[1]);
    }
}