import math
def solution(n, m):
    gcd_nums = math.gcd(n, m)
    lcm_nums = n * m / gcd_nums
    return [gcd_nums, lcm_nums]