import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] answer = new String[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            answer[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(answer, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        
        if(answer[0].equals("0")) return "0";
        
        StringBuilder sb = new StringBuilder();
        for(String num : answer) {
            sb.append(num);
        }
        
        return sb.toString();
    }
}