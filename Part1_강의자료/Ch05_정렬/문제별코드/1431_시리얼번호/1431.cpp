#include <stdio.h>
#include <string.h>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

struct Serial {
    string str;
    int sum;
    bool operator<(const Serial &o) const{
        if (str.length() != o.str.length())
            return str.length() < o.str.length();
        if (sum != o.sum)
            return sum < o.sum;
        return str < o.str;
    }
};

int main()
{
    int N;
    vector<Serial> serials;
    char str[51];

    scanf("%d", &N);
    for (int i = 0; i < N; i++)
    {
        scanf("%s", str);
        int sum = 0;
        int len = strlen(str);
        for (int j = 0; j < len; j++)
            if ('0' <= str[j] && str[j] <= '9')
                sum += str[j] - '0';
        serials.push_back({str, sum});
    }

    sort(serials.begin(), serials.end());

    for (int i = 0; i < serials.size(); i++)
        printf("%s\n", serials[i].str.c_str());
    return 0;
}
