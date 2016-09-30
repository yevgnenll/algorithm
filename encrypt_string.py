cnt = int(input())

aim_strings = []
for _ in range(cnt):
    aim_strings.append(input())

def encrypt_even_odd(strings):

    even_str = ''
    odd_str = ''
    for idx, s in enumerate(strings):
        if idx % 2 == 0:
            even_str += s
        else:
            odd_str += s
    return even_str + odd_str

for s in aim_strings:
    print(encrypt_even_odd(s))
