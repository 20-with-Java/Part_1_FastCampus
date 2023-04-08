#include <algorithm>
#include <map>
#include <stdio.h>
#include <vector>

using namespace std;

int main()
{
    int N, num;
    map<int, vector<int>> mp;

    scanf("%d", &N);
    vector<int> arr(N), res(N);

    for (int i = 0; i < N; i++)
    {
        scanf("%d", &arr[i]);
        mp[arr[i]].push_back(i);
    }
    
    int i = 0;
    for (auto it = mp.begin(); it != mp.end(); it++)
    {
        for (auto & v : it->second)
            res[v] = i;
        i++;
    }

    for (auto & it : res)
        printf("%d ", it);
    printf("\n");
    return 0;
}
