


def solution(arr):

    pre_height = 0
    cnt = 0

    for height in arr:
        if pre_height < height:
            cnt += (height - pre_height)
            pre_height = height
        elif pre_height > height:
            pre_height = height
        if cnt > 1000000000:
            return -1

    return cnt


print(solution([100,0,100]))
print(solution([1, 3, 2, 1, 2, 3, 4, 1]))

