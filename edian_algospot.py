cnt = int(input())

aim_strings = []
for _ in range(cnt):
    aim_strings.append(input())

def convert_edian(num):

    dec_to_bin = bin(int(num)).replace('0b', '000')
    lillput_to_blefuscu = dec_to_bin[::-1]

    from IPython import embed; embed()
    return int(lillput_to_blefuscu, 2)

for s in aim_strings:
    print(convert_edian(s))
