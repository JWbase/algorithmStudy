def solution(arr, n):
    length = len(arr)
    result = arr.copy()

    if length % 2 == 1:
        for i in range(0, length, 2):
            result[i] += n
    else:  
        for i in range(1, length, 2):
            result[i] += n

    return result

