a, b, c = map(int, input().split())


def mod_nums(a, b, c):

    if b == 0:
        return 1
    d = pow(a, b//2, c)
    print('d:', d)

    if b % 2 == 0:
        mid = d * d % c
        print(' % 2 == 0:', mid)
        return mid
    else:
        mid = (a * d * d) % c
        print(' % 2 == 1:', mid)
        return mid

print(mod_nums(a, b, c))
