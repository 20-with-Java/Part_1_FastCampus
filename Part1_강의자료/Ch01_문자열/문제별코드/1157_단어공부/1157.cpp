#include <stdio.h>
#include <string.h>

int num[30];
char str[1000005];

int main() {
    char res;
    int len, maxcnt = -1;

    scanf(" %s", str);
    len = strlen(str);
    for (int i = 0; i < len; ++i)
    {
        if (str[i] <= 'Z')
            ++num[str[i] - 'A'];
        else
            ++num[str[i] - 'a'];
    }

    for (int i = 0; i < 26; i++) 
    {
        if (num[i] == 0) continue;
        if (maxcnt == num[i])
            res = '?';
        else if (maxcnt < num[i]) 
        {
            res = i + 'A';
            maxcnt = num[i];
        }
    }
    printf("%c\n", res);
    return 0;
}

