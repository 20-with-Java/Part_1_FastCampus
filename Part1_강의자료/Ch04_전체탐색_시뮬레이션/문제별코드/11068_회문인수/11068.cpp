#include <stdio.h>

int T, X;

int is_palindrome(int x, int base)
{
    int digit[20];
    int len = 0;

    while (x > 0)
    {
        digit[len++] = x % base;
        x /= base;
    }

    for (int i = 0; i < len / 2; i++)
        if (digit[i] != digit[len - i - 1])
            return 0;
    return 1;
}

int main()
{
    int ans;

    scanf("%d", &T);
    while (T--)
    {
        scanf("%d", &X);

        for (int i = 2; i <= 64; i++)
        {
            ans = is_palindrome(X, i);
            if (ans)
                break;
        }

        printf("%d\n", ans);
    }
    return 0;
}
