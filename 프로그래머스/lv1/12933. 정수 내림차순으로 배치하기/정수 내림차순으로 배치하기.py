def solution(n):
    answer = ""
    answer2 = ""
    str_n = str(n)
    for i in str_n:
        answer += i
    new_answer = sorted(answer, reverse=True)
    for x in new_answer:
        answer2 += x
    return int(answer2)