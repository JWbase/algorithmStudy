import java.util.stream.IntStream;
import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] beforeArray = Arrays.copyOfRange(num_list, 0, n);
        int[] afterArray =  Arrays.copyOfRange(num_list, n, num_list.length);
        
        return IntStream
            .concat(Arrays.stream(afterArray), Arrays.stream(beforeArray))
            .toArray();
    }
}