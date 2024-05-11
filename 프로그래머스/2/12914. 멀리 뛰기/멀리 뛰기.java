class Solution {
    public long solution(int n) {
        // n이 1이거나 2인 경우는 각각 1, 2로 고정되므로 바로 반환
        if (n == 1) return 1;
        if (n == 2) return 2;

        // 각 칸에 도달하기 위한 방법의 수를 저장할 배열
        long[] ways = new long[n+1];
        ways[1] = 1; // 1칸을 뛰는 방법은 1가지
        ways[2] = 2; // 2칸을 뛰는 방법은 2가지 (1칸+1칸, 2칸)

        // 3칸 이상부터는 이전 두 칸의 방법의 수를 합하여 계산
        for (int i = 3; i <= n; i++) {
            ways[i] = (ways[i-1] + ways[i-2]) % 1234567;
        }

        // n칸에 도달하는 방법의 수를 1234567로 나눈 나머지 반환
        return ways[n];
    }
}