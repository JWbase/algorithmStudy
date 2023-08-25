import sys

input = sys.stdin.readline

st = []
answer = 0
n = list(input().strip())

for i in range(len(n)):
    if n[i] == '(':
        st.append(n[i])

    else:
        st.pop()
        if n[i - 1] == '(':
            answer += len(st)
        else:
            answer += 1

print(answer)