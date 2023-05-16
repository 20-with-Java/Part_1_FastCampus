N = int(input())

arr = list(map(int,input().split()))

appeared = [False] * 100001
ans_cnt = 0
next = 0
for i in range(N):
    while next < N:
        if appeared[arr[next]]:
            break
        appeared[arr[next]] = True
        next += 1
    ans_cnt += next - i
    appeared[arr[i]] = False

print(ans_cnt)
