def solution(myString, pat):
    new_myString = myString.upper()
    new_pat = pat.upper()
    if new_pat in new_myString:
        return 1
    else:
        return 0
    