def solution(n, k):
    answer = 0
    totalYang = 12000 * n
    totalDrink = 2000 * (k - (n // 10))
    answer = totalYang + totalDrink
    return answer