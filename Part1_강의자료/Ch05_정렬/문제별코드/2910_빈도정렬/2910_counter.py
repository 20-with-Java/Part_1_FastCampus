from collections import Counter

N, C = map(int, input().split())
arr = list(map(int, input().split()))

frequencies = Counter(arr)
sorted_nums = sorted(arr, key=lambda num: (-frequencies[num], arr.index(num)))

print(*sorted_nums)
