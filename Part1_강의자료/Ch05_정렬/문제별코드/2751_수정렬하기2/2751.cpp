#include <algorithm>
#include <stdio.h>
#include <vector>
using namespace std;

int main()
{
    int N;
    vector<int> vec;

    scanf("%d", &N);
    vec.resize(N);

    for (int i = 0; i < N; i++)
        scanf("%d", &arr[i]);

    sort(arr.begin(), arr.end());

    for (int i = 0; i < N; i++)
        printf("%d\n", arr[i]);

    return 0;
}
