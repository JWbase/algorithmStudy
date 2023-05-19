def solution(num_list):
    answer = 1
    answer_2 = 0
    for i in num_list:
        answer *= i
    for i in num_list:
        answer_2 += i
    if answer > answer_2 ** 2:
        return 0
    else:
        return 1