#include <stdio.h>
#include <set>
#include <string>
using namespace std;

int main()
{
    char str[501];
    int N, M;

    scanf("%d %d", &N, &M);
    set<string> st;
    for (int i = 0; i < N; i++)
    {
        scanf("%s", str);
        st.insert(str);
    }

    int cnt = 0;
    for (int i = 0; i < M; i++)
    {
        scanf("%s", str);
        if (st.count(str) == 1)
            cnt++;
    }

    printf("%d\n", cnt);
    return 0;
}
