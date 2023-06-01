def solution(num_list):
    answer = []
    for i in num_list:
        if i < 0:
            answer.append(num_list.index(i))
    if len(answer) == 0:
        return -1
    else:
        return answer[0]
            