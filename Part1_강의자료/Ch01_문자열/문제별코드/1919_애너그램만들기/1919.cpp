#include <math.h>
#include <stdio.h>
#include <string.h>

int arr[30];
char str1[1003], str2[1003];

int main()
{
    int len1, len2, res = 0;

    scanf(" %s %s", str1, str2);
    len1 = strlen(str1);
    len2 = strlen(str2);

    for (int i = 0; i < len1; ++i) 
        ++arr[str1[i] - 'a'];
    for (int i = 0; i < len2; ++i) 
        --arr[str2[i] - 'a'];
    for (int i = 'a'; i <= 'z'; ++i) 
        res += abs(arr[i - 'a']);
    
    printf("%d\n", res);
    return 0;
}

