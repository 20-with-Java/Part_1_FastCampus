N, M = map(int, input().split())
li = list(map(int, input().split()))

next_index = current_sum = ans = 0
for x in li:
    while current_sum < M and next_index < N:
        current_sum += li[next_index]
        next_index += 1
    if current_sum == M:
        ans += 1
    current_sum -= x
print(ans)
