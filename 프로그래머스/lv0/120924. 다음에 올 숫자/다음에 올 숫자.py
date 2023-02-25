def solution(common):
    answer = 0
    a1,a2,a3 = common[:3] #마지막 3개 가져오기 
    if (a2 - a1) == (a3 - a2):
        answer = common[-1] + (a3 - a2)
    elif (a2 // a1) == (a3 // a2):
        answer = common[-1] * (a3 // a2)
    return answer