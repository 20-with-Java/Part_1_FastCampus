N = int(input())
a = list(map(int, input().split()))
X = int(input())
cnt = [0] * 1000001
ans = 0

for i in range(N):
    cnt[a[i]] += 1

for i in range(1, (X - 1) // 2 + 1):
    if X - i <= 1000000:
        ans += cnt[i] * cnt[X - i]

print(ans)
