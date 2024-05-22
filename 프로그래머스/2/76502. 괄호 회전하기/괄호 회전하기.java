class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (isValid(s)) {
                answer++;
            }
            s = rotate(s);
        }
        
        return answer;
    }
        
         public String rotate(String s) {
        return s.substring(1, s.length()) + s.charAt(0);
    }
    
    public boolean isValid(String s) {
        while (s.contains("()") || s.contains("[]") || s.contains("{}")) {
            s = s.replace("()", "");
            s = s.replace("[]", "");
            s = s.replace("{}", "");
        }
        
        return s.length() == 0;
    }
}