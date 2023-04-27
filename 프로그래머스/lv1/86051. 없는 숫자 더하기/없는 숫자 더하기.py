def solution(numbers):
    answer = -1
    answer_list = [0,1,2,3,4,5,6,7,8,9]
    sort_numbers = sorted(numbers)

    for i in sort_numbers:
        answer_list.remove(i)
    answer = sum(answer_list)
    return answer