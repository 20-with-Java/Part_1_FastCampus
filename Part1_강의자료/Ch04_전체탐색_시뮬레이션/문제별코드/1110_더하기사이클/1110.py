N = int(input())
cur = N
len = 0

while True:
    cur = (cur // 10 + cur % 10) % 10 + (cur % 10) * 10
    len += 1
    if (cur == N):
        break

print(len)
