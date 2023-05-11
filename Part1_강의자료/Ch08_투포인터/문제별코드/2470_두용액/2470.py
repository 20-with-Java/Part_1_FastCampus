N = int(input())
arr = list(map(int, input().split()))

arr.sort()
left = 0
right = N - 1
ans_left = left
ans_right = right
ans_abs = abs(arr[ans_left] + arr[ans_right])
while left < right:
    cur_sum = arr[left] + arr[right]
    cur_abs = abs(cur_sum)
    if ans_abs > cur_abs:
        ans_abs = cur_abs
        ans_left = left
        ans_right = right
    if cur_sum > 0:
        right -= 1
    else:
        left += 1
print(arr[ans_left], arr[ans_right])
