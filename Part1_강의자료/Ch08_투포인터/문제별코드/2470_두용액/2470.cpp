#include <stdio.h>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    int N;

    scanf("%d", &N);
    vector<int> v(N);
    for (int i = 0; i < N; ++i)
        scanf("%d", &v[i]);

    sort(v.begin(), v.end());

    int left = 0;
    int right = N - 1;
    int ans_left = left;
    int ans_right = right;
    int ans_abs = abs(v[ans_left] + v[ans_right]);
    while (left < right) {
        int cur_sum = v[left] + v[right];
        int cur_abs = abs(cur_sum);
        if (ans_abs > cur_abs) {
            ans_abs = cur_abs;
            ans_left = left;
            ans_right = right;
        }
        if (cur_sum > 0) right--;
        else left++;
    }
    printf("%d %d\n", v[ans_left], v[ans_right]);
    return 0;
}
