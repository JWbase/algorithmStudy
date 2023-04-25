def solution(x):
    answer = True
    hashade_num = list(str(x))
    hashade_sum = 0
    for i in hashade_num:
        hashade_sum += int(i)
    if x % hashade_sum == 0:
        answer = True
    else:
        answer = False
    return answer
