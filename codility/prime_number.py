cnt = int(input())
numbers = list(map(int,input().split()))

def is_prime(num):
    if num < 2 :
        return False
    
    for i in range(2, num):
        if i*i > num:
            break
        if num % i == 0:
            return False
    return True

res = 0
for n in numbers:
    if is_prime(n):
        res += 1
print(res)
