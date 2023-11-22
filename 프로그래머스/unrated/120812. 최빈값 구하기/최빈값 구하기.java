import java.util.*;

class Solution {
    public int solution(int[] array) {
        int[] answerArray = new int[1000];        
        for (int i = 0; i < array.length; i++) {
            answerArray[array[i]]++;
        }
        
        int maxCount = 0;
        int mode = -1;
        for (int i = 0; i < answerArray.length; i++) {
            if (answerArray[i] > maxCount) {
                maxCount = answerArray[i];
                mode = i;
            }
        }
        
        int count = 0;
        for (int i = 0; i < answerArray.length; i++) {
            if (answerArray[i] == maxCount) {
                count++;
            }
        }
        
        if (count > 1) {
            return -1;
        } else {
            return mode;
        }
    }
}