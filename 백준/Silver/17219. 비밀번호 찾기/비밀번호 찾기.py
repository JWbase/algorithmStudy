import sys

input = sys.stdin.readline

N , M = map(int, input().split())
password = dict()

for _ in range(N):
    k , v = input().split()
    password[k] = v

for _ in range(M):
    search = input().strip()
    print(password[search])
