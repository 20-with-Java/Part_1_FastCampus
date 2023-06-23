N, M = map(int, input().split())
li = [0] + list(map(int, input().split()))
# import itertools
# acc = list(itertools.accumulate(li))
acc = [0] * (N + 1)
for i in range(1, N + 1):
    acc[i] = acc[i - 1] + li[i]

ans = 0
for i in range(1, N + 1):
    l, r = i, N
    while l <= r:
        m = (l + r) // 2
        current_sum = acc[m] - acc[i - 1]
        if current_sum > M:
            r = m - 1
        elif current_sum < M:
            l = m + 1
        else:
            ans += 1
            break

print(ans)
