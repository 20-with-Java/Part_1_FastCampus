#include <algorithm>
#include <stdio.h>
#include <string>

using namespace std;

string str;
int N, B;

int main()
{
    char ch;

    scanf("%d %d", &N, &B);
    while (N > 0)
    {
        ch = N % B;
        if (ch < 10)
            ch += '0';
        else
            ch += 'A' - 10;
        str.push_back(ch);
        N /= B;
    }
    reverse(str.begin(), str.end());
    printf("%s\n", str.c_str());
    return 0;
}
