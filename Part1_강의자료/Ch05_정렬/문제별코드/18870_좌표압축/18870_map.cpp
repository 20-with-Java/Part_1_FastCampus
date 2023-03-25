#include <algorithm>
#include <map>
#include <stdio.h>
#include <vector>

using namespace std;

int N, arr[1000005], res[1000005];
map<int, vector<int> > mp;

int main()
{
    int num;

    scanf(" %d", &N);
    for (int i = 0; i < N; i++)
    {
        scanf(" %d", &arr[i]);
        mp[arr[i]].push_back(i);
    }
    
    int i = 0;
    for (auto it = mp.begin(); it != mp.end(); it++)
    {
        for (auto & v : it->second)
            res[v] = i;
        ++i;
    }

    for (int i = 0; i < N; i++)
        printf("%d ", res[i]);
    printf("\n");
    return 0;
}
