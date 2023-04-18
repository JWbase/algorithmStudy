def solution(sides):
    sides.sort()
    answer = 0
    for _ in range(sides[1], sides[0] + sides[1]):
        answer += 1
    for i in range(1, sides[1]):
        if i + sides[0] > sides[1]:
            answer += 1
    return answer