#include <algorithm>
#include <stdio.h>
#include <vector>

using namespace std;

int main()
{
    int N;

    scanf("%d", &N);
    vector<int> house(N);
    for (int i = 0; i < N; i++)
        scanf("%d", &house[i]);
    sort(house.begin(), house.end());
    
    printf("%d\n", house[(N - 1) / 2]);
    return 0;
}
