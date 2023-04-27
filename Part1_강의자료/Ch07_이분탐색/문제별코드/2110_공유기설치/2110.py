N, C = map(int,input().split())
li = sorted([int(input()) for _ in range(N)])

def calc_count(dist):
    past_x, cnt = li[0], 1
    for i in range(1, N):
        if li[i] - past_x >= dist:
            past_x = li[i]
            cnt += 1
    return cnt

l, r = 1, (li[N - 1] - li[0]) // (C - 1)
while l <= r:
    mid = (l + r) // 2
    if calc_count(mid) >= C:
        l = mid + 1
    else:
        r = mid - 1
print(r)
