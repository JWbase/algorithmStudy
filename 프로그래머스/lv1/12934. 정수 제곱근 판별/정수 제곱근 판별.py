import math

def solution(n):
    answer = 0
    rt_n = math.sqrt(n)
    if int(rt_n) == rt_n:
        answer += (rt_n + 1) ** 2
    else:
        answer += -1
    return answer