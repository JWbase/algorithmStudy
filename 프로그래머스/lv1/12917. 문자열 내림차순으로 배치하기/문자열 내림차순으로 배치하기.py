def solution(s):
    answer = sorted(s, reverse=True)
    new_answer = "".join(answer)
    return new_answer