import sys

input = sys.stdin.readline

N , L = map(int, input().split())

coord = [False] * 1001
for i in map(int, input().split()):
    coord[i] = True

# 현재 살펴보고 있는 좌표
x = 0
answer = 0
while x < 1001:
    if coord[x]:
        answer += 1
        x += L
    else:
        x += 1

print(answer)