import math
def solution(n, m):
    answer = []
    gcd_nums = math.gcd(n, m)
    lcm_nums = n * m / gcd_nums
    answer.append(gcd_nums)
    answer.append(lcm_nums)
    return answer