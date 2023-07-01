def solution(my_string, is_suffix):
    if len(is_suffix) > len(my_string):
        return 0
    
    suffix_length = len(is_suffix)
    suffix = my_string[-suffix_length:]
    
    if suffix == is_suffix:
        return 1
    else:
        return 0