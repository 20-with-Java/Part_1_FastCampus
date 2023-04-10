N = int(input())
st = set(map(int,input().split()))
M = int(input())
for i in map(int,input().split()):
    print(int(i in st))
