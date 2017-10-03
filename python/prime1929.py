m, n = map(int, input().split())


# prime -> true, not prime -> false
def get_prime_range(m, n):
    nums = [False for range(1, n+1)]

    nums[1] = False # 1 is not prime

