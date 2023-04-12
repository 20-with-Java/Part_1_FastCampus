import sys
import bisect
input = sys.stdin.readline

N = int(input())
li = sorted(list(map(int, input().split())))
M = int(input())
for num in map(int, input().split()):
    print(bisect.bisect_right(li, num) - bisect.bisect_left(li, num), end=' ')
