W, H = map(int, input().split())
P, Q = map(int, input().split())
T = int(input())

p = (P + T) % (2 * W)
q = (Q + T) % (2 * H)
if p > W:
    p = 2 * W - p
if q > H:
    q = 2 * H - q

print(p, q)
