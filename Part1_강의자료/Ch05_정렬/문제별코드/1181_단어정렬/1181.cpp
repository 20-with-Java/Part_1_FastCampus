#include <algorithm>
#include <stdio.h>
#include <string>
#include <vector>

using namespace std;

int cmp(const string &a, const string &b)
{
    return (a.length() == b.length() ? a < b : a.length() < b.length());
}

int main()
{
    char str[55];
    int N;
    vector<string> vec;

    scanf("%d", &N);
    for (int i = 0; i < N; i++)
    {
        scanf("%s", str);
        vec.push_back(str);
    }

    sort(vec.begin(), vec.end(), cmp);
    vec.erase(unique(vec.begin(), vec.end()), vec.end());

    for (auto & it : vec)
        printf("%s\n", it.c_str());
    return 0;
}
