#include <stdio.h>
#include <string.h>
#include <algorithm>
using namespace std;

int get_unique_alphabet_count(int *alphabet_count)
{
    int unique_alphabet_count = 0;
    for (int i = 0; i < 26; i++)
        if (alphabet_count[i] > 0)
            unique_alphabet_count++;
    return unique_alphabet_count;
}

int main()
{
    int N;
    char nyang[100005];

    scanf("%d", &N);
    scanf("%s", nyang);

    int alphabet_count[26];
    int next = 0;
    int max_length = 0;
    int len = strlen(nyang);
    for (int i = 0; i < len; i++)
    {
        while (next < len)
        {
            alphabet_count[nyang[next++] - 'a']++;
            if (get_unique_alphabet_count(alphabet_count) > N)
            {
                alphabet_count[nyang[--next] - 'a']--;
                break;
            }
        }
        max_length = max(max_length, next - i);
        alphabet_count[nyang[i] - 'a']--;
    }

    printf("%d\n", max_length);
}
