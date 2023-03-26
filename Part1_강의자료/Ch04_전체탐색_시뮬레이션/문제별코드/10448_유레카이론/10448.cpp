#include <stdio.h>
#include <vector>
using namespace std;

int T, K;
int is_eureka[1001];
vector<int> triangle_nums;

int main()
{
    for (int i = 1; ; i++)
    {
        int num = i * (i + 1) / 2;
        if (num > 1000)
            break;
        triangle_nums.push_back(num); 
    }

    for (int i = 0; i < triangle_nums.size(); i++)
    {
        for (int j = i; j < triangle_nums.size(); j++)
        {
            for (int k = j; k < triangle_nums.size(); k++)
            {
                int num = triangle_nums[i] + triangle_nums[j] + triangle_nums[k];
                if (num > 1000)
                    break;
                is_eureka[num] = 1;
            }
        }
    }

    scanf("%d", &T);
    while (T--)
    {
        scanf("%d", &K);
        printf("%d\n", is_eureka[K]);
    }
    return 0;
}
