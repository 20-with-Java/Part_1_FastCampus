N, M = map(int, input().split())
li = sorted(list(input().rstrip() for _ in range(N)))

def is_exist(x):
    l, r = 0, N - 1
    while l <= r:
        m = (l + r) // 2
        if li[m] == x:
            return True
        if li[m] < x:
            l = m + 1
        else:
            r = m - 1
    return False

cnt = 0
for x in [input().rstrip() for _ in range(M)]:
    if is_exist(x):
       cnt += 1
print(cnt)
