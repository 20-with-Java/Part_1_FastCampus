#include <stdio.h>
#include <vector>
using namespace std;
typedef long long ll;

int main()
{
    int N;

    scanf("%d", &N);
    vector<int> v(N);
    for (int i = 0; i < N; i++)
        scanf("%d", &v[i]);

    vector<bool> appeared(100001);
    ll ans_cnt = 0;
    int next = 0;
    for (int i = 0; i < N; i++)
    {
        while (next < N)
        {
            if (appeared[v[next]])
                break;
            appeared[v[next++]] = true;
        }
        ans_cnt += next - i;
        appeared[v[i]] = false;
    }

    printf("%lld\n", ans_cnt);
    return 0;
}
