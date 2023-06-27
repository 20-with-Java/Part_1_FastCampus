#include <stdio.h>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
    int N;
    
    scanf("%d", &N);
    vector<int> distance(N);
    int distance_sum = 0;
    for (int i = 0; i < N; i++)
    {
        scanf("%d", &distance[i]);
        distance_sum += distance[i];
    }

    int pair_index = 1;
    int left_distance = distance[0];
    int right_distance = distance_sum - distance[0];
    int max_distance = min(left_distance, right_distance);
    for (int i = 0; i < N; i++)
    {
        while (left_distance < right_distance)
        {
            left_distance += distance[pair_index];
            right_distance -= distance[pair_index];
            pair_index = (pair_index + 1) % N;
        }
        max_distance = max(max_distance, min(left_distance, right_distance));

        left_distance -= distance[i];
        right_distance += distance[i];
    }

    printf("%d\n", max_distance);
    return 0;
}
