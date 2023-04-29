def solution(s):
    answer = True
    if len(s) == 6 or len(s) == 4:
        if s.isdigit():
            return True
        else:
            return False
    else:
        return False