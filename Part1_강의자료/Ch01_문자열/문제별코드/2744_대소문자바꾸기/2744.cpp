#include <stdio.h>
#include <string.h>

int main()
{
	char s[101];
    scanf("%s", s);

    int len = strlen(s);
	for (int i = 0; i < len; i++){
        if ('A' <= s[i] && s[i] <= 'Z')
            s[i] = 'a' + s[i] - 'A';
        else s[i] = 'A' + s[i] - 'a';
	}
    printf("%s\n", s);

	return 0;
}
