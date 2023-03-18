P = int(input())

for T in range(1, P + 1):
    h = list(map(int, input().split())) [1:]
    cnt = 0

    for i in range(20):
        for j in range(i):
            if h[j] > h[i]:
                myH = h[i]
                for k in range(i, j, -1):
                    h[k] = h[k - 1]
                    cnt += 1
                h[j] = myH
                break

    print(T, cnt)
