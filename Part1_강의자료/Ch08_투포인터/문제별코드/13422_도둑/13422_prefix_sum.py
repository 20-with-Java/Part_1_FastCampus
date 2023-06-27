def get_range_sum(acc, l, r):
    if l <= r:
        return acc[r] - acc[l - 1]
    return acc[len(acc) - 1] - acc[l - 1] + acc[r]

for _ in range(int(input())):
    N, M, K = map(int, input().split())
    money = [0] + list(map(int, input().split()))
    acc_money = [0] * (N + 1)
    for i in range(1, N + 1):
        acc_money[i] = acc_money[i - 1] + money[i]

    ans = 0
    for i in range(1, N + 1):
        if get_range_sum(acc_money, i, (i + M - 2) % N + 1) < K:
            ans += 1
    if N == M:
        ans = min(1, ans)
    print(ans)
