N, K = map(int, input().split())
cur_idx = 0
ans = ['?' for i in range(N)]
check = [0 for i in range(26)]

for i in range(K):
    S, C = input().split()
    S = int(S)
    next_idx = ((cur_idx - S) % N + N) % N
    if ans[next_idx] != '?' and ans[next_idx] != C:
        print("!")
        break
    elif ans[next_idx] == '?' and C in ans:
        print("!")
        break
    ans[next_idx] = C
    cur_idx = next_idx

    if i == K - 1:
        ans = ans[cur_idx:] + ans[:cur_idx]
        print("".join(ans))
