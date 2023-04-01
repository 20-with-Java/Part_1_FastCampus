#include <algorithm>
#include <stdio.h>
#include <vector>

using namespace std;

typedef struct {
    long long start;
    long long end;
} meeting;


bool cmp(meeting a, meeting b) 
{ 
    return a.end == b.end ? a.start < b.start : a.end < b.end;
}

int main()
{
    int N;
    vector<meeting> meetings;
    
    scanf("%d", &N);
    meetings.resize(N);

    for (int i = 0; i < N; i++)
        scanf("%lld %lld", &meetings[i].start, &meetings[i].end);
    sort(meetings.begin(), meetings.end(), cmp);

    long long end_time = 0, res = 0;
    for (int i = 0; i < N; i++)
    {
        if (end_time <= meetings[i].start) 
        {
            res++;
            end_time = meetings[i].end;
        }
    }

    printf("%long longd\n", res);
    return 0;
}
