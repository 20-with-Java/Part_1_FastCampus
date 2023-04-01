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
        scanf("%d", &vec[i]);

    sort(vec.begin(), vec.end());

    for (int i = 0; i < N; i++)
        printf("%d\n", vec[i]);

    return 0;
}
