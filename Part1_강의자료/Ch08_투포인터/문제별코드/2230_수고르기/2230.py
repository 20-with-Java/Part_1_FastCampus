N, M = map(int, input().split())
arr = [int(input()) for _ in range(N)]

arr.sort()

ans_diff = arr[N - 1] - arr[0]
right = 0
for left in range(N):
    while right < N - 1 and arr[right] - arr[left] < M:
        right += 1
    diff = arr[right] - arr[left]
    if diff >= M:
        ans_diff = min(ans_diff, diff)

print(ans_diff)
