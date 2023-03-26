#include <stdio.h>
#include <algorithm>
using namespace std;

#define MAX_NUMBER 10000
bool is_selfnum[MAX_NUMBER + 1];

int generate(int seed)
{
    int num = seed;
    while (seed > 0)
    {
        num += seed % 10;
        seed /= 10;
    }
    return num;
}

int main()
{
    fill(is_selfnum, is_selfnum + MAX_NUMBER + 1, true);

    for (int i = 1; i <= MAX_NUMBER; i++)
    {
        int seed = i;
        while (1)
        {
            int num = generate(seed);
            if (num > MAX_NUMBER)
                break;
            is_selfnum[num] = false;
            seed = num;
        }
    }

    for (int i = 1; i <= MAX_NUMBER; i++)
        if (is_selfnum[i])
            printf("%d\n", i);
    return 0;
}
