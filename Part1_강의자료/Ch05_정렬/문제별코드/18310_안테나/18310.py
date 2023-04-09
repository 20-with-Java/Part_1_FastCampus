N = int(input())
house = list(map(int, input().split()))

house.sort()
print(house[(N - 1) // 2])
