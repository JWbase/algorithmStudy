def solution(arr1, arr2):
    rows = len(arr1)
    cols = len(arr1[0])
    
    result = [[0 for j in range(cols)] for i in range(rows)]
    
    for i in range(rows):
        for j in range(cols):
            result[i][j] = arr1[i][j] + arr2[i][j]
    
    return result