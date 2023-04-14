import sys
input = sys.stdin.readline

N, M = map(int, input().split())
use_amounts = [int(input()) for _ in range(N)]

def is_possible(mid):
    draw_cnt, current_amount = 1, mid
    for use_amount in use_amounts:
        current_amount -= use_amount
        if current_amount < 0:
            current_amount = mid - use_amount
            draw_cnt += 1
    return draw_cnt <= M

l, r = max(use_amounts), sum(use_amounts)
while l < r:
    mid = (l + r) // 2
    if is_possible(mid):
        r = mid
    else:
        l = mid + 1
print(l)
