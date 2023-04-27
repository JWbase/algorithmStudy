def solution(arr):
    answer = []
    sort_arr = sorted(arr)
    if len(arr) == 1:
        answer.append(-1)
    else:
        arr.remove(sort_arr[0])
        answer = arr
            
    return answer