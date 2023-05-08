N = int(input())
arr = sorted([int(input()) for _ in range(N)])
sums = sorted([(arr[i] + arr[j]) for i in range(N) for j in range(i, N)])

def is_exist(A):
    left, right = 0, len(sums)
    while left <= right:
        mid = (left + right) // 2
        if sums[mid] < A:
            left = mid + 1
        elif sums[mid] > A:
            right = mid - 1
        else:
            return 1
    return 0

flag = False
for i in range(N - 1, 0, -1):
    for j in range(i - 1, -1, -1):
        if is_exist(arr[i] - arr[j]):
            print(arr[i])
            flag = True
            break
    if flag is True:
        break
