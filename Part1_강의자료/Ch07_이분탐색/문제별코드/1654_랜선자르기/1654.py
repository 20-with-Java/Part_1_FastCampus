K, N = map(int, input().split())
lans = [int(input()) for _ in range(K)]

def calc_count(length):
    cnt = 0
    for lan in lans:
        cnt += (lan // length)
    return cnt

l, r = 1, max(lans)
res = -1
while l <= r:
    mid = (l + r) // 2
    if calc_count(mid) >= N:
        l = mid + 1
        res = mid
    else:
        r = mid - 1
print(res)
