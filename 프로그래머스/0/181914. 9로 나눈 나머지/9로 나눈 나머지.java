class Solution {
    public int solution(String number) {
        int answer = 0;
        String[] numbers = number.split("");
        int temp = 0;
        for (String num : numbers) {
            temp += Integer.parseInt(num);
        }
        answer = temp % 9 ;
        return answer;
    }
}