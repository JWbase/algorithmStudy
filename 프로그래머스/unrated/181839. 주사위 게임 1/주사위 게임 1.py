def solution(a, b):
    if a % 2 == 1 and b % 2 == 1:  # a와 b가 모두 홀수인 경우
        return a ** 2 + b ** 2
    elif a % 2 == 1 or b % 2 == 1:  # a와 b 중 하나만 홀수인 경우
        return 2 * (a + b)
    else:  # a와 b가 모두 홀수가 아닌 경우
        return abs(a - b)
