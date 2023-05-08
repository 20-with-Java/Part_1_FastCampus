N = int(input())
li = sorted(list(map(int,input().split())))

def is_exist(A):
    left, right = 0, N - 1
    while left <= right:
        mid = (left + right) // 2
        if li[mid] < A:
            left = mid + 1
        elif li[mid] > A:
            right = mid - 1
        else:
            return 1
    return 0

M = int(input())
for i in map(int,input().split()):
    print(is_exist(i))
