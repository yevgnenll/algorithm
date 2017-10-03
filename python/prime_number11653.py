cnt = int(input())
n = list(map(int,input().split()))


def get_prime_numbers(n):

    if n < 2:
        return False
    for i in range(2, n):
        if i * i <= n:
            if n % i == 0:
                return False
        else:
            break

    return True


prime_cnt = 0
for i in range(cnt):
    if get_prime_numbers(n[i]):
        prime_cnt += 1

print(prime_cnt)
