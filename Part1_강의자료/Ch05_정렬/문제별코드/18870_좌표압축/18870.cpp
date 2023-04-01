#include <stdio.h>
#include <algorithm>
#define MIN -0x3f3f3f3f

using namespace std;

typedef struct {
    int num;
    int idx;
} coord;

bool cmp(coord a, coord b) 
{
    return a.num < b.num;
}

int main()
{
    int N;
    vector<int> ans;
    vector<coord> arr;
    scanf("%d", &N);
    ans.resize(N);
    arr.resize(N);

    for (int i = 0; i < N; i++)
    {
        scanf("%d", &arr[i].num);
        arr[i].idx = i;
    }
    sort(arr.begin(), arr.end(), cmp);
    arr.push_back({ MIN, 0 });
    
    int idx = 0;
    for (int i = 0; i < N; i++)
    {
        if (arr[i].num == arr[i + 1].num)
            ans[arr[i].idx] = idx;
        else 
            ans[arr[i].idx] = idx++;
    }

    for (int i = 0; i < N; i++)
        printf("%d ", ans[i]);
    printf("\n");
    return 0;
}
