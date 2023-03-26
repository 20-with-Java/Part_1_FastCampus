#include <stdio.h>

int N;

int main()
{
    int len = 0, cur;
    
    scanf("%d", &N);
    cur = N;
    do {
        cur = (cur / 10 + cur % 10) % 10 + (cur % 10) * 10;
        len++;
    } while (cur != N);
    printf("%d\n", len);
    return 0;
}
