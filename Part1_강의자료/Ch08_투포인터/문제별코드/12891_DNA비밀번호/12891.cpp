#include <iostream>
#include <map>
#include <string>
#include <vector>
using namespace std;

bool is_valid_sequence(int minimum_base_count[4], int current_base_count[4])
{
    for (int i = 0; i < 4; i++)
        if (current_base_count[i] < minimum_base_count[i])
            return false;
    return true;
}

int main()
{
    int S, P, minimum_base_count[4];
    string sequence;
    cin >> S >> P >> sequence;
    for (int i = 0; i < 4; i++)
        cin >> minimum_base_count[i];

    map<char, int> dic;
    dic['A'] = 0;
    dic['C'] = 1;
    dic['G'] = 2;
    dic['T'] = 3;

    int current_base_count[4] = { 0 };
    for (int i = 0; i < P; i++)
        current_base_count[dic[sequence[i]]]++;

    int ans = is_valid_sequence(minimum_base_count, current_base_count);
    for (int i = 1; i <= S - P; i++)
    {
        current_base_count[dic[sequence[i - 1]]]--;
        current_base_count[dic[sequence[i + P - 1]]]++;
        ans += is_valid_sequence(minimum_base_count, current_base_count);
    }
    cout << ans << '\n';
    return 0;
}
