#include <stdio.h>
#include <vector>
using namespace std;

bool is_possible(vector<int> &lengths, int video_length, int video_count)
{
    int current_length = 0, current_count = 1;
    for (auto & len : lengths)
    {
        if (len > video_length)
            return false;
        if (current_length + len > video_length)
        {
            if (++current_count > video_count) 
                return false;
            current_length = 0;
        }
        current_length += len;
    }
    return true;
}

int main()
{
    int N, M;
    scanf("%d %d", &N, &M);
    
    vector<int> lengths(N);
    for (int i = 0; i < N; i++)
        scanf("%d", &lengths[i]);

    int l = 1, r = N * 10000, ans = -1;
    while (l <= r)
    {
        int mid = (l + r) / 2;
        if (is_possible(lengths, mid, M))
        {
            ans = mid;
            r = mid - 1;
        }
        else
            l = mid + 1;
    }
    printf("%d\n", ans);
    return 0;
}
