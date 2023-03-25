import sys
input = sys.stdin.readline

N = int(input())
li = list(map(int, input().split()))
st = sorted(list(set(li)))
dic = {st[i] : i for i in range(len(st))}

for i in li:
    print(dic[i], end=' ')
