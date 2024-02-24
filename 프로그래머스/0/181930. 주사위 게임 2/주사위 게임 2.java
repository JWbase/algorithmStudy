import java.util.*;

class Solution {
    public int solution(int a, int b, int c) {
        if (a == b && a == c && b == c) {
            return ((a + b + c) * (cal(a, 2) + cal(b, 2) + cal(c ,2)) * (cal(a, 3) + cal(b, 3) + cal(c, 3)));
        }
        
        if (a != b && a != c && b != c) {
            return (a + b + c);
        }
        
        return ((a + b + c) * (cal(a, 2) + cal(b, 2) + cal(c ,2)));
    }
    
    private int cal(int a, int b) {
        return (int) Math.pow(a, b);
    }
}