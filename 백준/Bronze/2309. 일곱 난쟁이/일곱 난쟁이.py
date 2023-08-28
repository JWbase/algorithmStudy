from itertools import combinations
import sys

input = sys.stdin.readline

dwarfs = []
for d in range(9):
    dwarfs.append(int(input()))
dwarfs.sort()

sorted_dwarfs = combinations(dwarfs, 7)
for i in sorted_dwarfs:
    if sum(i) == 100:
        for num in i:
            print(num)
        break