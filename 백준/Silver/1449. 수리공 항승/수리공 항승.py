import sys

input = sys.stdin.readline

N , L = map(int, input().split())

coord = list(map(int, input().split())) #좌표 압축
coord.sort()
answer = 0
x = 0
while x <= coord[-1]:
    if x in coord:
        answer += 1
        x = x + L
    else:
        x += 1
print(answer)