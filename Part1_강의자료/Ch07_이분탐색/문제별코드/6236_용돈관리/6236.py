import sys
input = sys.stdin.readline

N, K = map(int, input().split())
li = [int(input()) for _ in range(N)]

def lower_bound(mid):
	cnt = 1
	cur = mid
	for i in li:
		cur -= i
		if cur < 0:
			cur = mid - i
			cnt += 1
	return cnt <= K

l, r = max(li), sum(li)
while l < r:
	mid = (l + r) >> 1
	if lower_bound(mid):
		r = mid
	else:
		l = mid + 1

print(l)
