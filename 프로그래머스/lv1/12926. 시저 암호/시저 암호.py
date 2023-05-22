def solution(s, n):
    answer = ''
    for char in s:
        if char.isalpha():
            if char.isupper():
                shifted = chr((ord(char) - ord('A') + n) % 26 + ord('A'))
            else:
                shifted = chr((ord(char) - ord('a') + n) % 26 + ord('a'))
            answer += shifted
        else:
            answer += char
    return answer
