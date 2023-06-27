#include <stdio.h>
#include <vector>
using namespace std;
#define INF 0x3f3f3f3f

int main()
{
    int N, M;
    scanf("%d %d", &N, &M);

    vector<int> vec1(N + 1);
    for (int i = 0; i < N; i++) 
        scanf("%d", &vec1[i]);

    vector<int> vec2(M + 1);
    for (int i = 0; i < M; i++)
        scanf("%d", &vec2[i]);
    vec1[N] = INF;
    vec2[M] = INF;

    int index1 = 0, index2 = 0;
    while (index1 < N || index2 < M)
    {
        if (vec1[index1] < vec2[index2])
            printf("%d ", vec1[index1++]);
        else
            printf("%d ", vec2[index2++]);
    }
    return 0;
}
