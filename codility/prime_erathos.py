start, end = map(int, input().split())

def erathos(start, end):
    numbers = [False for _ in range(end+1)]
    prime_numbers = []
    numbers[0] = True
    numbers[1] = True
    for num, prime in enumerate(numbers):
        if prime:
            continue
        prime_numbers.append(num)
        for i in range(num*num, end+1, num):
            numbers[i] = True

    print_primes(prime_numbers, start)
    
def is_prime(num):
    if num < 2 :
        return False
    
    for i in range(2, num):
        if i*i > num:
            break
        if num % i == 0:
            return False
    return True


def print_primes(arr, start):
    for i in arr:
        if i >= start:
            print(i)

erathos(start, end)
