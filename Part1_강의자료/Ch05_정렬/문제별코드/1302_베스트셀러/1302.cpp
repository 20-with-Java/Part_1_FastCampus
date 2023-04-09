#include <stdio.h>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

int main()
{
    int N;
    vector<string> titles;
    char title[51];

    scanf("%d", &N);
    for (int i = 0; i < N; i++)
    {
        scanf("%s", title);
        titles.push_back(title);
    }

    sort(titles.begin(), titles.end());

    string max_title = titles[0];
    int max_cnt = 1;
    int cur_cnt = 1;
    for (int i = 1; i < N; i++)
    {
        if (titles[i - 1] != titles[i])
            cur_cnt = 0;
        cur_cnt++;
        if (max_cnt < cur_cnt || (max_cnt == cur_cnt && titles[i] < max_title))
        {
            max_cnt = cur_cnt;
            max_title = titles[i];
        }
    }

    printf("%s\n", max_title.c_str());
    return 0;
}
