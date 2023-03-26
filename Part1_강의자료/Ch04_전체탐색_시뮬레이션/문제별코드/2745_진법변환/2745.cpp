#include <stdio.h>

char N[32];
int B;

int main()
{
    scanf("%s %d", N, &B);

    int num_dec = 0;
    for (int i = 0; N[i]; i++)
    {
        char digit = N[i];
        num_dec *= B;
        if ('0' <= digit && digit <= '9')
            num_dec += digit - '0';
        else
            num_dec += 10 + digit - 'A';
    }
    
    printf("%d\n", num_dec);
    return 0;
}
