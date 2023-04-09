def solution(array, n):
    distant = array[0]
    min_diff = abs(distant - n)
    
    for num in array[1:]:
        diff = abs(num - n)
        if diff < min_diff or (diff == min_diff and num < distant):
            distant = num
            min_diff = diff
    return distant