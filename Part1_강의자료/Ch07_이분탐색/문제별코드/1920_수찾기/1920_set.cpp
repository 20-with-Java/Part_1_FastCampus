#include <algorithm>
#include <set>
#include <stdio.h>
using namespace std;

int main()
{
    int N, M;
    set<int> st;

    scanf("%d", &N);

    int num;
    for (int i = 0; i < N; i++)
    {
        scanf("%d", &num);
        st.insert(num);
    }

    int A;
    scanf("%d", &M);
    for (int i = 0; i < M; i++)
    {
        scanf("%d", &A);
        printf("%d\n", st.find(A) != st.end());
    }

    printf("\n");
    return 0;
}
