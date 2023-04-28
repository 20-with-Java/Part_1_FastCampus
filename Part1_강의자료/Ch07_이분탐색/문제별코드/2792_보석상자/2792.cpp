#include <algorithm>
#include <stdio.h>
#include <vector>
using namespace std;

int main()
{
    int N, M;
    scanf("%d %d", &N, &M);

    int max_num = -1;
    vector<int> jewels(M);
    for (int i = 0; i < M; i++)
    {
        scanf("%d", &jewels[i]);
        max_num = max(max_num, jewels[i]);
    }
    int l = 1, r = max_num;
    while (l < r)
    {
        int mid = (l + r) / 2, children_cnt = 0;
        for (auto & jewel : jewels)
            children_cnt += jewel / mid + (jewel % mid ? 1 : 0);
        if (children_cnt <= N)
            r = mid;
        else
            l = mid + 1;
    }
    printf("%d\n", r);
    return 0;
}
