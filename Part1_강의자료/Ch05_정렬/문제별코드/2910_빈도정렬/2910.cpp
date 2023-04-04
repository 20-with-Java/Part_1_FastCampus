#include <stdio.h>
#include <vector>
#include <algorithm>
using namespace std;

struct message {
    int num;
    int idx;
    bool operator<(const message &o) const{
        if (num != o.num)
            return num < o.num;
        return idx < o.idx;
    }
};

struct frequency {
    int num;
    int count;
    int first_idx;
    bool operator<(const frequency &o) const{
        if (count != o.count)
            return count > o.count;
        return first_idx < o.first_idx;
    }
};

int main()
{
    int N, C;
    vector<message> messages;
    vector<frequency> frequencies;
    int x;

    scanf("%d %d", &N, &C);
    for (int i = 0; i < N; i++)
    {
        scanf("%d", &x);
        messages.push_back({x, i});
    }

    sort(messages.begin(), messages.end());
    
    frequencies.push_back({messages[0].num, 1, messages[0].idx});
    for (int i = 1; i < N; i++)
    {
        if (messages[i].num != messages[i - 1].num)
            frequencies.push_back({messages[i].num, 0, messages[i].idx});
        frequencies.back().count++;
    }

    sort(frequencies.begin(), frequencies.end());

    for (int i = 0; i < frequencies.size(); i++)
        while (frequencies[i].count--)
            printf("%d ", frequencies[i].num);
    printf("\n");
    return 0;
}
