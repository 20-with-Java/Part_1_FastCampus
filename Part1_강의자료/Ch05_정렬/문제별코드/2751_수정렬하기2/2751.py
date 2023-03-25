import sys
input = sys.stdin.readline

N = int(input())
li = [int(input()) for _ in range(N)]

for i in sorted(li):
    print(i)
