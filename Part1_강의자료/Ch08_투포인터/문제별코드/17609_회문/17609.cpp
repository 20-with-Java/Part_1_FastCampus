#include <stdio.h>
#include <string.h>

int is_palindrome(char *str, int l, int r)
{
    while (l <= r)
    {
        if (str[l] != str[r])
            return 0;
        l++;
        r--;
    }
    return 1;
}

int main()
{
    int T;
    char str[100005];

    scanf("%d", &T);
    while (T--)
    {
        scanf("%s", str);

        int ans = 0;
        int l = 0;
        int r = strlen(str) - 1;
        while (l <= r)
        {
            if (str[l] != str[r])
            {
                if (is_palindrome(str, l + 1, r) || is_palindrome(str, l, r - 1))
                    ans = 1;
                else
                    ans = 2;
                break;
            }
            l++;
            r--;
        }
        
        printf("%d\n", ans);
    }
}
