N, M = map(int, input().split())
jewels = [int(input()) for _ in range(M)]

l, r = 1, max(jewels)
while l < r:
    mid = (l + r) // 2
    if sum([jewel // mid + int(jewel % mid != 0) for jewel in jewels]) <= N:
        r = mid
    else:
        l = mid + 1
print(r)
