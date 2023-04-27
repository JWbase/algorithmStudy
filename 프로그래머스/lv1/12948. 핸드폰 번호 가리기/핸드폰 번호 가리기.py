def solution(phone_number):
    answer = ''
    star_phone = ''
    for i in range(len(phone_number) - 4):
        star_phone += '*'
    star_phone += phone_number[-4:]
    return star_phone