T = int(input())
N = int(input())
li1 = list(map(int, input().split()))
M = int(input())
li2 = list(map(int, input().split()))

part_sums = []
for i in range(N):
    cur = 0
    for j in range(i, N):
        cur += li1[j]
        part_sums.append(cur)
part_sums.sort()

def find_lower_bound_index(x):
    idx = len(part_sums)
    l, r = 0, len(part_sums) - 1
    while l <= r:
        m = (l + r) // 2
        if part_sums[m] < x:
            l = m + 1
        else:
            r = m - 1
            idx = m
    return idx

def find_upper_bound_index(x):
    idx = len(part_sums)
    l, r = 0, len(part_sums) - 1
    while l <= r:
        m = (l + r) // 2
        if part_sums[m] <= x:
            l = m + 1
        else:
            r = m - 1
            idx = m
    return idx
    
ans = 0    
for i in range(M):
    cur = 0
    for j in range(i, M):
        cur += li2[j]
        to_find = T - cur
        ans += find_upper_bound_index(to_find) - find_lower_bound_index(to_find)

print(ans)
