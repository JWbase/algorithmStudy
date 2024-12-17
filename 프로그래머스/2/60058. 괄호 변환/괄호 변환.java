class Solution {
    public String solution(String p) {
        if (p.isEmpty()) {
            return "";
        }
        
        int index = separateUV(p);
        String u = p.substring(0, index);
        String v = p.substring(index);
        
        if (isCorrect(u)) {
            return u + solution(v);
        }
        
        StringBuilder result = new StringBuilder();
        result.append("(");
        result.append(solution(v));
        result.append(")");
        
        if (u.length() > 2) {
            String substring = u.substring(1, u.length() - 1);
            result.append(reverse(substring));
        }
        
        return result.toString();
    }
    
    private int separateUV(String p) {
        int count = 0;
        int index = 0;
        
        for (char c : p.toCharArray()) {
            if (c == '(') {
                count++;
            } else {
                count--;
            }
            index++;
            if (count == 0) {
                break;
            }
        }
        return index;
    }
    
    private boolean isCorrect(String str) {
        int count = 0;
        
        for (char c : str.toCharArray()) {
            if (c == '(') {
                count++;
            } else {
                if (count == 0) {
                    return false;
                }
                count--;
            }
        }
        return count == 0;
    }
    
    private String reverse(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c == '(') {
                sb.append(')');
            } else {
                sb.append('(');
            }
        }
        return sb.toString();
    }
}