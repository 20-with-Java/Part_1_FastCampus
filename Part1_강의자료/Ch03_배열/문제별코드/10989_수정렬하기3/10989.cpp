#include <stdio.h>

int N, arr[10005];

int main()
{
    scanf("%d", &N);
    
    int num;
    for (int i = 0; i < N; i++)
    {
        scanf("%d", &num);
        arr[num]++;
    }	
    
    for (int i = 1; i < 10001; ++i)
        while (arr[i]--)
            printf("%d\n", i);

    return 0;
}
