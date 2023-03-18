#include <stdio.h>
typedef long long ll;

int N, X;
int a[100000];
int cnt[1000001];

int main()
{
    ll ans = 0;

    scanf("%d", &N);
    for (int i = 0; i < N; i++)
        scanf("%d", a + i);
    scanf("%d", &X);

    for (int i = 0; i < N; i++)
        cnt[a[i]]++;

    for (int i = 1; i <= (X - 1) / 2; i++)
        if (X - i <= 1000000)
            ans += (ll)cnt[i] * cnt[X - i];

    printf("%lld\n", ans);
    return 0;
}
