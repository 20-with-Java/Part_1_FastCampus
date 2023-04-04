#include <stdio.h>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

struct member {
    int age;
    string name;
    int idx;
    bool operator<(const member &o) const{
        if (age != o.age)
            return age < o.age;
        return idx < o.idx;
    }
};

int main()
{
    int N;
    vector<member> members;
    int age;
    char name[101];

    scanf("%d", &N);
    for (int i = 0; i < N; i++)
    {
        scanf("%d %s", &age, name);
        members.push_back({age, name, i});
    }

    sort(members.begin(), members.end());

    for (int i = 0; i < N; i++)
        printf("%d %s\n", members[i].age, members[i].name.c_str());

    return 0;
}
