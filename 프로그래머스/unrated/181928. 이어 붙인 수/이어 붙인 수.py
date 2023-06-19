def solution(num_list):
    answer = 0
    ans_even = ''
    ans_odd = ''
    for i in num_list:
        if i % 2 == 1:
            ans_odd += str(i)
        else:
            ans_even += str(i)
    answer = int(ans_odd) + int(ans_even)
    return answer