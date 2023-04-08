import sys
input = sys.stdin.readline

N = int(input())
li = [tuple(map(int, input().split())) for _ in range(N)]
li.sort(key=lambda x:(x[1], x[0]))

end = -1
res = 0
for pair in li:
    if end <= pair[0]:
        res += 1
        end = pair[1]

print(res)
