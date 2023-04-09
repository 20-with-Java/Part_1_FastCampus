import sys
input = sys.stdin.readline

N = int(input())
arr = [int(input()) for _ in range(N)]

arr.sort()

for i in range(N):
    print(arr[i])
