#include <algorithm>
#include <iostream>
#include <string>
using namespace std;

int main()
{
    int N, B, W;
    string color;
    cin >> N >> B >> W >> color;

    int next_index = 0, ans = 0, white_count = 0, black_count = 0;
    for (int i = 0; i < N; i++)
    {
        while (next_index < N)
        {
            if (black_count == B && color[next_index] == 'B')
                break;
            if (color[next_index++] == 'W')
                white_count++;
            else
                black_count++;
        }
        if (white_count >= W)
            ans = max(ans, next_index - i);
        if (color[i] == 'W')
            white_count--;
        else
            black_count--;
    }
    
    cout << ans << '\n';
    return 0;
}
