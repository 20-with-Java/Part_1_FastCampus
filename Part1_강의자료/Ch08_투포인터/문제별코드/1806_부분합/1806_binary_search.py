N, S = map(int, input().split())
li = [0] + list(map(int, input().split()))
acc = [0] * (N + 1)
for i in range(1, N + 1):
    acc[i] = acc[i - 1] + li[i]

ans = N + 1
for i in range(1, N + 1):
    l, r = i, N
    while l <= r:
        m = (l + r) // 2
        current_sum = acc[m] - acc[i - 1]
        if current_sum >= S:
            ans = min(ans, m - i + 1)
            r = m - 1
        else:
            l = m + 1

print(0 if ans == N + 1 else ans)
