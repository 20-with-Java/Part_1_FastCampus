#include <algorithm>
#include <stdio.h>
#include <string>
#include <vector>
using namespace std;

bool is_exist(vector<string> &vec, string x)
{
    int l = 0, r = vec.size() - 1;
    while (l <= r)
    {
        int m = (l + r) / 2;
        if (vec[m] == x)
            return true;
        vec[m] < x ? l = m + 1 : r = m - 1;
    }
    return false;
}

int main()
{
    char str[501];
    int N, M;

    scanf("%d %d", &N, &M);
    vector<string> vec(N);
    for (int i = 0; i < N; i++)
    {
        scanf("%s", str);
        vec[i] = str;
    }
    sort(vec.begin(), vec.end());

    int cnt = 0;
    for (int i = 0; i < M; i++)
    {
        scanf("%s", str);
        if (is_exist(vec, str))
            cnt++;
    }

    printf("%d\n", cnt);
    return 0;
}
