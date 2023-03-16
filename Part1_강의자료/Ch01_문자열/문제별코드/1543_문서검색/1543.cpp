#include <stdio.h>
#include <string.h>

char doc[2501];
char word[51];

int main()
{
    int count = 0;

    scanf(" %[^\n]", doc);
    scanf(" %[^\n]", word);

    int word_len = strlen(word);
    char *start_pointer = doc;
    while (1)
    {
        char *find = strstr(start_pointer, word);
        if (find == NULL)
            break;
        start_pointer = find + word_len;
        count++; 
    }

    printf("%d\n", count);
    return 0;
}
