#include <algorithm>
#include <stdio.h>
#include <string.h>
#include <vector>

using namespace std;

typedef struct score {
    int vote;
    char ch;
    bool operator<(const struct score &A) const {
        return (vote > A.vote);
    }
}score;

int main()
{
    int name[30], X, N, vote;

    memset(name, -1, sizeof(name));
    scanf("%d %d", &X, &N);

    vector<score> scores;
    char ch;

    for (int i = 0; i < N; ++i)
    {
        scanf(" %c %d", &ch, &vote);
        if (vote * 20 >= X)
        {
            name[ch - 'A'] = 0;
            for (int j = 1; j <= 14; ++j)
                scores.push_back({ vote / j, ch });
        }
    }
    
    sort(scores.begin(), scores.end());
    int idx = 0;

    if (N != 0)
    {
        for (auto it = scores.begin(); idx < 14 && it != scores.end(); ++it, ++idx)
            ++name[it->ch - 'A'];
        for (int i = 0; i < 26; ++i)
            if (name[i] != -1)
                printf("%c %d\n", i + 'A', name[i]);
    }
    return 0;
}
