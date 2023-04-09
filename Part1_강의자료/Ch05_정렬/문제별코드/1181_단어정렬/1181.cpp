#include <algorithm>
#include <stdio.h>
#include <string>
#include <vector>

using namespace std;

int main()
{
    char str[55];
    int N;

    scanf("%d", &N);
    vector<string> vec(N);
    for (int i = 0; i < N; i++)
    {
        scanf("%s", str);
        vec[i] = str;
    }

    sort(vec.begin(), vec.end(), [](const string& a, const string& b){
        return (a.length() == b.length() ? a < b : a.length() < b.length());
    });

    printf("%s\n", vec[0].c_str());
    for (int i = 1; i < vec.size(); i++)
        if (vec[i - 1] != vec[i])
            printf("%s\n", vec[i].c_str());
    
    return 0;
}
