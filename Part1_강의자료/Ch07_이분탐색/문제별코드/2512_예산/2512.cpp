#include <algorithm>
#include <stdio.h>
#include <vector>
using namespace std;

int main()
{
    int N;
    scanf("%d", &N);
    
    int max_budget = -1;
    vector<int> budgets(N);
    for (int i = 0; i < N; i++)
    {
        scanf("%d", &budgets[i]);
        max_budget = max(max_budget, budgets[i]);
    }

    int M, l = 1, r = max_budget, res = -1;
    // r = *max_element(budgets.begin(), budgets.end());
    scanf("%d", &M);
    while (l <= r)
    {
        int mid = (l + r) / 2, sum = 0;
        for (auto & it : budgets)
            sum += min(mid, it);
        if (sum <= M)
        {
            res = mid;
            l = mid + 1;
        }
        else
            r = mid - 1;
    }

    printf("%d\n", res);
    return 0;
}
