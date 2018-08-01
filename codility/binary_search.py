import sys
sys.setrecursionlimit(150000000)


def b_search(arr, first, last, target):

    print(arr, first, last)
    if first > last:
        return -1;

    mid = (first + last) // 2
    if arr[mid] == target:
        return mid
    elif arr[mid] < target:
        return b_search(arr, mid-1, last, target)
    else:
        return b_search(arr, first, mid-1, target)


print(b_search([1,3,5,7,9], 0, 5, 7))
