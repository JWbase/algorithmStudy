import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        class Num {
            int value;
            int distance;
            
            Num(int value, int distance) {
                this.value = value;
                this.distance = distance;
            }
        }
        
        List<Num> list = new ArrayList<>();
        
        for (int num : numlist) {
            list.add(new Num(num, Math.abs(num - n)));
        }
        
        Collections.sort(list, (a, b) -> {
            if (a.distance == b.distance) {
                return b.value - a.value;
            } else {
                return a.distance - b.distance;
            }
        });

        int[] answer = new int[numlist.length];
        for (int i = 0; i < numlist.length; i++) {
            answer[i] = list.get(i).value;
        }
        
        return answer;
    }
}