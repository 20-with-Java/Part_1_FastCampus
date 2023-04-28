N = int(input())
budgets = list(map(int,input().split()))
M = int(input())

l, r, ans = 1, max(budgets), -1
while l <= r:
    mid = (l + r) // 2
    if sum([min(mid, budget) for budget in budgets]) <= M:
        ans = mid
        l = mid + 1
    else:
        r = mid - 1
print(ans)
