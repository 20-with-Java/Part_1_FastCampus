N, M = map(int, input().split())
trees = list(map(int,input().split()))

l, r = 0, max(trees)
while l <= r:
    m = (l + r) // 2
    if sum([tree - m for tree in trees if tree > m]) < M:
        r = m - 1
    else:
        l = m + 1

print(r)
