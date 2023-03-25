#include <stdio.h>
#include <algorithm>
#define MIN -0x3f3f3f3f

using namespace std;

typedef struct 
{
    int num;
    int idx;
} coord;

coord arr[1000005];
int N, ans[1000005];

bool cmp(coord a, coord b) 
{
    return a.num < b.num;
}

int main()
{
    scanf("%d", &N);

    arr[N].num = MIN;
    for (int i = 0; i < N; i++)
    {
        scanf("%d", &arr[i].num);
        arr[i].idx = i;
    }
    sort(arr, arr + N, cmp);
    
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