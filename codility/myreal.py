


def problem(n):

    index = int(n)

    numbers = [0, 1]
    if n == 0:
        return 0
    if n == 1:
        return 1
   # 3 -> 
    for num in range(1, index):
        numbers.append(numbers[num] + numbers[num-1])

    return numbers[index]


def fibonachi(number):

    n = int(number)
    if n == 0:
        return 0
    if n == 1:
        return 1
    return fibonachi(n-1) + fibonachi(n-2)


num = input()
print(problem(num))
print(fibonachi(num))
