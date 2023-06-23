N, M = map(int, input().split())
li1 = list(map(int, input().split())) + [1000000001]
li2 = list(map(int, input().split())) + [1000000001]

index1 = index2 = 0
while index1 < N or index2 < M:
    if li1[index1] < li2[index2]:
        print(li1[index1], end=' ')
        index1 += 1
    else:
        print(li2[index2], end=' ')
        index2 += 1
print()
