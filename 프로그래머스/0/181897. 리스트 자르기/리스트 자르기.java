import java.util.*;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
               int a = slicer[0];
        int b = slicer[1];
        int c = slicer[2];
        
        List<Integer> resultList = new ArrayList<>();
        
        switch (n) {
            case 1:
                for (int i = 0; i <= b; i++) {
                    resultList.add(num_list[i]);
                }
                break;
            case 2:
                for (int i = a; i < num_list.length; i++) {
                    resultList.add(num_list[i]);
                }
                break;
            case 3:
                for (int i = a; i <= b; i++) {
                    resultList.add(num_list[i]);
                }
                break;
            case 4:
                for (int i = a; i <= b; i += c) {
                    resultList.add(num_list[i]);
                }
                break;
        }
        
        // List<Integer>를 int[]로 변환
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        
        return result;
    }
}