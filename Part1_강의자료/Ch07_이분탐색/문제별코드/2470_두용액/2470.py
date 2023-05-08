N = int(input())
li = sorted(list(map(int, input().split())))

def find_nearest_value(left, right, value):
    nearest_value = li[left]
    nearest_diff = abs(value - nearest_value)
    l, r = left + 1, right

    while l <= r:
        mid = (l + r) // 2
        diff = abs(value - li[mid])
        if diff < nearest_diff:
            nearest_value = li[mid]
            nearest_diff = diff
        if li[mid] < value:
            l = mid + 1
        elif li[mid] > value:
            r = mid - 1
        else:
            return value
    return nearest_value

ans_abs = abs(li[0] + li[1])
ans1, ans2 = li[0], li[1]
for i in range(0, N - 1):
    pair_value = find_nearest_value(i + 1, N - 1, -li[i])
    sum_abs = abs(li[i] + pair_value)
    if ans_abs > sum_abs:
        ans_abs = sum_abs
        ans1, ans2 = li[i], pair_value

print(ans1, ans2)
