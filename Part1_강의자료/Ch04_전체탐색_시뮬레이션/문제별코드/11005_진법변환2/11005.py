N, B = map(int, input().split())
arr = []

while N > 0:
    ch = N % B
    if ch < 10:
        arr.append(chr(ch) + ord('0'))
    else:
        arr.append()