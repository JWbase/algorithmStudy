class Solution {
    public String solution(String my_string, int s, int e) {
        String reversedPart = new StringBuilder(my_string.substring(s, e + 1)).reverse().toString();
        String result = my_string.substring(0, s) + reversedPart + my_string.substring(e + 1);
        return result;
    }
}