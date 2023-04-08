#include <algorithm>
#include <stdio.h>
#include <vector>

using namespace std;

struct Meeting {
    int start;
    int end;
};

int main()
{
    int N;
    
    scanf("%d", &N);
    vector<Meeting> meetings(N);

    for (int i = 0; i < N; i++)
        scanf("%d %d", &meetings[i].start, &meetings[i].end);
        
    sort(meetings.begin(), meetings.end(), [](const Meeting& a, const Meeting& b) {
        return a.end == b.end ? a.start < b.start : a.end < b.end;
    });

    int end_time = 0, res = 0;
    for (int i = 0; i < N; i++)
    {
        if (end_time <= meetings[i].start) 
        {
            res++;
            end_time = meetings[i].end;
        }
    }

    printf("%d\n", res);
    return 0;
}
