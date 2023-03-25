T = int(input())

for _ in range(T):
    H, W, N = map(int, input().split())

    floor = (N - 1) % H + 1
    number = (N - 1) // H + 1

    print(floor * 100 + number)
