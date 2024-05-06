class Solution {
    public int solution(int n) {
        int nOneCount = countOnes(n); // n의 1의 개수를 세는 함수 호출
        int nextBigNumber = n + 1; // n 다음의 숫자로 시작

        // 다음 큰 숫자를 찾을 때까지 반복
        while (countOnes(nextBigNumber) != nOneCount) {
            nextBigNumber++; // 1씩 증가시키면서 조건에 맞는지 검사
        }

        return nextBigNumber; // 조건에 맞는 다음 큰 숫자 반환
    }
    
        private int countOnes(int number) {
        int count = 0;

        while (number > 0) {
            count += number & 1; // 마지막 비트가 1이면 count 증가
            number >>= 1; // 비트를 오른쪽으로 하나씩 이동
        }

        return count;
    }
}