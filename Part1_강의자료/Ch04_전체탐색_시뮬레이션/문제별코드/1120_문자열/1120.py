A, B = input().split()
res = 50

for i in range(len(B) - len(A) + 1):
    cnt = 0
    for j in range(len(A)):
        if A[j] != B[i + j]:
            cnt += 1
    res = min(res, cnt)
print(res)
