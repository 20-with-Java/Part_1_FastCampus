import sys
#import bisect
input = sys.stdin.readline

N = int(input())
li = sorted(list(map(int, input().split())))

def find_lower_bound_idx(x):
    idx = len(li)
    l, r = 0, len(li) - 1

    while l <= r:
        m = (l + r) // 2
        if li[m] < x:
            l = m + 1
        else:
            r = m - 1
            idx = m
    return idx

def find_upper_bound_idx(x):
    idx = len(li)
    l, r = 0, len(li) - 1

    while l <= r:
        m = (l + r) // 2
        if li[m] <= x:
            l = m + 1
        else:
            r = m - 1
            idx = m
    return idx

M = int(input())
for num in map(int, input().split()):
    print(find_upper_bound_idx(num) - find_lower_bound_idx(num), end=' ')
    #print(bisect.bisect_right(li, num) - bisect.bisect_left(li, num), end=' ')
