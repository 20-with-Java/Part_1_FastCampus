#include <stdio.h>

unsigned long long calc_sqrt_integer(unsigned long long N)
{
    unsigned long long l = 0, r = 1L << 32;

    while (l <= r)
    {
        unsigned long long mid = (l + r) / 2;
        if (mid * mid == N) 
            return mid;
        if (mid * mid < N)
            l = mid + 1;
        else
            r = mid - 1;
    }
    return r + 1;
}

int main()
{
    unsigned long long N;
    scanf("%llu", &N);
    printf("%llu\n", calc_sqrt_integer(N));
    return 0;
}
