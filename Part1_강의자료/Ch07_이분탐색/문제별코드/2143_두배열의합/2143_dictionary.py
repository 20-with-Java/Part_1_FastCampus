T = int(input())
N = int(input())
li1 = list(map(int, input().split()))
M = int(input())
li2 = list(map(int, input().split()))

dic = {}
for i in range(N):
    cur = 0
    for j in range(i, N):
        cur += li1[j]
        if cur in dic.keys():
            dic[cur] += 1
        else:
            dic[cur] = 1

ans = 0    
for i in range(M):
    cur = 0
    for j in range(i, M):
        cur += li2[j]
        if T - cur in dic.keys():
            ans += dic[T - cur]
print(ans)
