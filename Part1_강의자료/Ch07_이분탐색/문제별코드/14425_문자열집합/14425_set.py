N, M = map(int, input().split())
st = set(input().rstrip() for _ in range(N))

cnt = 0
for x in [input().rstrip() for _ in range(M)]:
    if x in st:
       cnt += 1
print(cnt)
