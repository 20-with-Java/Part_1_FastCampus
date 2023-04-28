N = int(input())
arr = sorted([int(input()) for _ in range(N)])

sums = set()
for i in range(N):
    for j in range(i, N):
        sums.add(arr[i] + arr[j])

flag = False
for i in range(N - 1, 0, -1):
    for j in range(i - 1, -1, -1):
        if arr[i] - arr[j] in sums:
            print(arr[i])
            flag = True
            break
    if flag is True:
        break
