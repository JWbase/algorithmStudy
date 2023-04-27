def solution(absolutes, signs):
    answer = 123456789
    real_num = 0
    plus_minus = []
    for i in signs:
        if i == True:
            plus_minus.append('+')
        elif i == False:
            plus_minus.append('-')
      
    for i in range(len(absolutes)):  
        real_num += int(plus_minus[i] + str(absolutes[i]))
    return real_num