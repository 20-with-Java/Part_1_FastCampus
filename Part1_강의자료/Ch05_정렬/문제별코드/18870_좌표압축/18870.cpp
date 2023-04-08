#include <stdio.h>
#include <algorithm>
#define MIN -0x3f3f3f3f

using namespace std;

struct Coord {
    int num;
    int idx;
};

int main()
{
    int N;
    
    scanf("%d", &N);
    vector<int> ans(N);
    vector<Coord> arr(N);

    for (int i = 0; i < N; i++)
    {
        scanf("%d", &arr[i].num);
        arr[i].idx = i;
    }

    sort(arr.begin(), arr.end(), [](const Coord& a, const Coord& b) {
        return a.num < b.num;
    });

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
