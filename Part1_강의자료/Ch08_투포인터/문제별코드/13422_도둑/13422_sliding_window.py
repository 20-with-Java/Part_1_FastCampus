for _ in range(int(input())):
    N, M, K = map(int, input().split())
    money = list(map(int, input().split()))
    
    current_sum = sum(money[:M])

    ans = 1 if current_sum < K else 0
    if N != M:
        for i in range(1, N):
            current_sum -= money[i - 1]
            current_sum += money[(i + M - 1) % N]
            if current_sum < K:
                ans += 1

    print(ans)
