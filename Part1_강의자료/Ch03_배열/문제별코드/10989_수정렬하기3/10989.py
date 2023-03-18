import sys
input = sys.stdin.readline

N = int(input())
arr = [0] * 10001

for _ in range(N):
    arr[int(input())] += 1

for i in range(1, 10001):
    while arr[i] > 0:
        print(i)
        arr[i] -= 1
