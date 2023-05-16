class Bucket:
    def __init__(self, g, x):
        self.g = g
        self.x = x

N, K = map(int, input().split())

buckets = []
for i in range(N):
    g, x = map(int, input().split())
    buckets.append(Bucket(g, x))

sorted_buckets = sorted(buckets, key=lambda bucket: bucket.x)

next = 0
max_sum = 0
cur_sum = 0
for i in range(N):
    while next < N and sorted_buckets[next].x - sorted_buckets[i].x <= 2 * K:
        cur_sum += sorted_buckets[next].g
        next += 1
    max_sum = max(max_sum, cur_sum)
    cur_sum -= sorted_buckets[i].g

print(max_sum)
