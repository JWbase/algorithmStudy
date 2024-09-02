class Solution {
    public int solution(String s) {
        int count = 0;
        int i = 0;

        while (i < s.length()) {
            char x = s.charAt(i);
            int xCount = 0;
            int notXCount = 0;
            
            while (i < s.length()) {
                if (s.charAt(i) == x) {
                    xCount++;
                } else {
                    notXCount++;
                }
                i++;
                
                if (xCount == notXCount) {
                    break;
                }
            }
            count++;
        }
        
        return count;
    }
}