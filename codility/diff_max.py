lenth = int(input())
numbers = list(map(int, input()))

numbers.sort()

def calculate(numbers):
    total = 0
    length = len(numbers)
    for idx, number in enumerate(numbers):
        if idx == length -1 :
            break
        total += abs(numbers[idx] - numbers[idx])
    return total

def next_permutation(arr):
    temp = 0
    for i in range(len(arr)):
        temp = a[i+1]
        a[i+1] = temp
