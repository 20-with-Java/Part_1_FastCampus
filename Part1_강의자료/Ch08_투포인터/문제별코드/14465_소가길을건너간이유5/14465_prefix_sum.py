N, K, B = map(int, input().split())
is_broken = [0] * (N + 1)
for _ in range(B):
    is_broken[int(input())] = 1

acc_broken = [0] * (N + 1)
for i in range(1, N + 1):
    acc_broken[i] = acc_broken[i - 1] + is_broken[i]

ans = K
for i in range(1, N - K + 2):
    ans = min(ans, acc_broken[i + K - 1] - acc_broken[i - 1])
print(ans)
