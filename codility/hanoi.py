def hanoi(num, start, by, to, cnt=1):
    cnt += 1

    if num == 1:
        print("원반 {num}를 {start}에서 {to}로 이동 {cnt}".format(
            num=num,
            start=start,
            to=to,
            cnt=cnt,
            )
        )
    else:
        hanoi(num-1, start, to, by, cnt)
        print("원반 {num}를 {start}에서 {to}로 이동 {cnt}".format(
            num=num,
            start=start,
            to=to,
            cnt=cnt,
            )
        )
        hanoi(num-1, by, start, to, cnt)


hanoi(100, 'A', 'B', 'C')
