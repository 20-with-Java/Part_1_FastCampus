#include <algorithm>
#include <stdio.h>

using namespace std;

typedef long long ll;

typedef struct {
	ll start;
	ll end;
} meeting;

int N;
meeting meetings[100005];

bool cmp(meeting a, meeting b) 
{ 
    return a.end == b.end ? a.start < b.start : a.end < b.end;
}

int main()
{
	scanf("%d", &N);

	for (int i = 0; i < N; i++)
		scanf("%lld %lld", &meetings[i].start, &meetings[i].end);
	sort(meetings, meetings + N, cmp);

    ll end_time = 0, res = 0;
	for (int i = 0; i < N; i++)
    {
		if (end_time <= meetings[i].start) 
        {
			res++;
			end_time = meetings[i].end;
		}
	}

	printf("%lld\n", res);
	return 0;
}
