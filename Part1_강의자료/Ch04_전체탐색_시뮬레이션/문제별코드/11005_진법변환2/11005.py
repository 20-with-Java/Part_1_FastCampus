N, B = map(int, input().split())
res = ''

while N > 0:
    ch = N % B
    if ch > 9:
        res += chr(ch + ord('A') - 10)
    else:
        res += str(ch)
    N = N // B

print(res[::-1])
