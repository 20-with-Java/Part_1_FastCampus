#include <map>
#include <stdio.h>
using namespace std;

int main()
{
    int N;
    map<int, int> mp;

    int card;
    scanf("%d", &N);
    for (int i = 0; i < N; i++)
    {
        scanf("%d", &card);
        mp[card]++;
    }

    int M;
    scanf("%d", &M);
    for (int i = 0; i < M; i++)
    {
        scanf("%d", &card);
        auto it = mp.find(card);
        if (it == mp.end())
            printf("0 ");
        else
            printf("%d ", it->second);
    }
    return 0;
}
