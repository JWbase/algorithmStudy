from itertools import permutations
def solution(babbling):
    answer = 0
    sound = ["aya", "ye", "woo","ma"]
    combi = []
    for i in range(1, len(sound)+1):
        for j in permutations(sound, i):
            combi.append("".join(j))
            
    for i in babbling:
        if i in combi:
            answer += 1
            
    
    return answer