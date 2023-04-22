N, K, B = map(int, input().split())
is_broken = [0] * (N + 1)
for _ in range(B):
    is_broken[int(input())] = 1

broken_cnt = sum(is_broken[1:K+1])
ans = broken_cnt
for i in range(2, N - K + 2):
    broken_cnt += is_broken[i + K - 1] - is_broken[i - 1]
    ans = min(ans, broken_cnt)

print(ans)
