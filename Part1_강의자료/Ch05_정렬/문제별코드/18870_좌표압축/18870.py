import sys
input = sys.stdin.readline

N = int(input())
li = list(map(int, input().split()))
st = sorted(set(li))
dic = {num: i for i, num in enumerate(st)}

print(' '.join([str(dic[num]) for num in li]))
