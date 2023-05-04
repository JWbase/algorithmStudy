def solution(d, budget):
    d.sort()  # 부서별 신청 금액을 오름차순으로 정렬
    count = 0  # 지원 가능한 부서의 개수
    for i in d:
        if budget < i:
            break  # 예산을 초과한 경우 반복문 탈출
        budget -= i  # 지원한 금액만큼 예산에서 차감
        count += 1
    return count
