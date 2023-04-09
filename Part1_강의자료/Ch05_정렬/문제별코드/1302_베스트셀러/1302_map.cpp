#include <stdio.h>
#include <map>
#include <string>
using namespace std;

int main()
{
    int N;
    map<string, int> titles;
    char title[51];

    scanf("%d", &N);
    for (int i = 0; i < N; i++)
    {
        scanf("%s", title);
        titles[title]++;
    }

    string max_title = "";
    int max_cnt = 0;
    for (auto title : titles)
    {
        if (title.second > max_cnt || (title.second == max_cnt && title.first < max_title))
        {
            max_title = title.first;
            max_cnt = title.second;
        }
    }

    printf("%s\n", max_title.c_str());
    return 0;
}
