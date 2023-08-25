import heapq as hq
import sys

input = sys.stdin.readline

pq = []
for _ in range(int(input())):
    x = int(input())
    if x:
       hq.heappush(pq, x)
    else:
        print(hq.heappop(pq) if pq else 0)