N = int(input())

arr = list(map(int,input().split()))

appeared = [False] * 100001
ans_cnt = 0
next_idx = 0
for i in range(N):
    while next_idx < N:
        if appeared[arr[next_idx]]:
            break
        appeared[arr[next_idx]] = True
        next_idx += 1
    ans_cnt += next_idx - i
    appeared[arr[i]] = False

print(ans_cnt)
