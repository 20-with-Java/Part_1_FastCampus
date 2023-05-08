#include <algorithm>
#include <stdio.h>
#include <vector>
using namespace std;

bool is_possible(vector<int> &use_amounts, int M, int mid)
{
    int draw_cnt = 1, current_amount = mid;
    for (auto & use_amount : use_amounts)
    {
        current_amount -= use_amount;
        if (current_amount < 0)
        {
            current_amount = mid - use_amount;
            draw_cnt++;
        }
    }
    return draw_cnt <= M;
}

int main()
{
    int N, M;
    scanf("%d %d", &N, &M);
    vector<int> use_amounts(N);
    int l = -1, r = 0;
    
    for (int i = 0; i < N; i++)
    {
        scanf("%d", &use_amounts[i]);
        l = max(l, use_amounts[i]);
        r += use_amounts[i];
    }

    while (l < r)
    {
        int mid = (l + r) / 2;
        if (is_possible(use_amounts, M, mid))
            r = mid;
        else
            l = mid + 1;
    }
    printf("%d\n", l);
    return 0;
}
