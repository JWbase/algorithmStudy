def solution(emergency):
# 먼저 주어진 배열을 내림차순으로 정렬
# 그다음 빈 배열을 만들고
# 원래 배열을 포문 돌려서
# 빈 배열에 원래 배열의 값에 해당하는 인덱스값을 찾아서 값을 넣고 그값의 1을 더해서 배열에 넣음
    answer = []
    sort_emergency = sorted(emergency, reverse=True)
    for i in emergency:
        answer.append(sort_emergency.index(i) + 1)
    return answer