class Solution {
    static int answer = 0;    
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }
    
    public void dfs(int[] numbers, int target, int index, int num) {
        if(index == numbers.length) {
            if(num == target) {
                answer++;
            }
        return;
        }
        dfs(numbers, target, index + 1, num + numbers[index]);
        dfs(numbers, target, index + 1, num - numbers[index]);
    }
    

}