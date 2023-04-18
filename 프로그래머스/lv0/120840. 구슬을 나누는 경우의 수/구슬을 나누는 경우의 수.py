def solution(balls, share):
    def recu(x):
        if x == 0 or x == 1:
            return 1
        else:
            return x * recu(x-1)
    answer = 0
    answer = recu(balls) / (recu(balls - share) * recu(share))
    return answer