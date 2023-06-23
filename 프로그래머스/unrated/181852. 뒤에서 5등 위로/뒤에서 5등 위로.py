def solution(num_list):
    answer = []
    arr_num_list = sorted(num_list)
    for i in range(5, len(arr_num_list)):
        answer.append(arr_num_list[i])
    return answer