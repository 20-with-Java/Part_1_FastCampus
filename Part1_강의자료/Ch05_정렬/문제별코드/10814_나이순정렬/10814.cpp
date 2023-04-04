#include <stdio.h>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

typedef struct {
    int age;
    string name;
    int idx;
} member;

bool compare(member &a, member &b)
{
    if (a.age != b.age)
        return a.age < b.age;
    return a.idx < b.idx;
}

int main()
{
    int N;
    vector<member> members;
    int age;
    char name[101];

    scanf("%d", &N);
    members.resize(N);
    for (int i = 0; i < N; i++)
    {
        scanf("%d %s", &age, name);
        members[i].age = age;
        members[i].name = name;
        members[i].idx = i;
    }

    sort(members.begin(), members.end(), compare);

    for (int i = 0; i < N; i++)
        printf("%d %s\n", members[i].age, members[i].name.c_str());

    return 0;
}
