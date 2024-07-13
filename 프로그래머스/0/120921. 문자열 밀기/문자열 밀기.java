class Solution {
    public int solution(String A, String B) {
        if (A.length() != B.length()) {
            return -1;
        }
        
        String temp = A;
        for (int i = 0; i < A.length(); i++) {
            if (temp.equals(B)) {
                return i;
            }
            
            char lastChar = temp.charAt(temp.length() - 1);
            temp = lastChar + temp.substring(0, temp.length() - 1);
        }
        
        return -1;
    }
}