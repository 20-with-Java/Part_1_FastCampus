N, S = map(int, input().split())
li = list(map(int, input().split()))

next_index = current_sum = 0
ans = N + 1
for i in range(N):
    while current_sum < S and next_index < N:
        current_sum += li[next_index]
        next_index += 1
    if current_sum >= S:
        ans = min(ans, next_index - i)
    current_sum -= li[i]

print(0 if ans == N + 1 else ans)
