def calc_sqrt_integer(N):
    l, r = 0, 1 << 32
    while l <= r:
        mid = (l + r) // 2
        if mid * mid == N:
            return mid
        if mid * mid < N:
            l = mid + 1
        else:
            r = mid - 1
    return r + 1
    
print(calc_sqrt_integer(int(input())))
