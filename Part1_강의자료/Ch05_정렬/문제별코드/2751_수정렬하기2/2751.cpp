#include <stdio.h>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
    int N;

    scanf("%d", &N);
    vector<int> v(N);
    for (int i = 0; i < N; i++)
        scanf("%d", &v[i]);

    sort(v.begin(), v.end());

    for (int i = 0; i < N; i++)
        printf("%d\n", v[i]);
    return 0;
}
