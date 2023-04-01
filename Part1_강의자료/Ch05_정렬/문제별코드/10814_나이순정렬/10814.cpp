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
    vector<member> v;
    int age;
    char name[101];

    scanf("%d", &N);
    v.resize(N);
    for(int i = 0; i < N; i++)
    {
        scanf("%d %s", &age, name);
        v[i].age = age;
        v[i].name = name;
        v[i].idx = i;
    }

    sort(v.begin(), v.end(), compare);

    for(int i = 0; i < N; i++)
        printf("%d %s\n", v[i].age, v[i].name.c_str());

    return 0;
}
