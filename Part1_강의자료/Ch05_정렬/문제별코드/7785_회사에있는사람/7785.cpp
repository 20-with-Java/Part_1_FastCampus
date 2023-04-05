#include <algorithm>
#include <functional>
#include <set>
#include <stdio.h>
#include <string>
#include <string.h>

using namespace std;

int main()
{
    char name[6], log[6];
    int N;
    set<string, greater<string>> st;

    scanf("%d", &N);
    for (int i = 0; i < N; i++)
    {
        scanf("%s %s", name, log);
        if (strcmp(log, "enter") == 0)
            st.insert(name);
        else
            st.erase(st.find(name));
    }

    for (auto & it : st)
        printf("%s\n", it.c_str());
    return 0;
}
