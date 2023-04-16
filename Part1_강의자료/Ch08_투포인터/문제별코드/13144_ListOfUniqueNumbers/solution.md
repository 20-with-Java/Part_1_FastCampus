### BOJ [13144] List of Unique Numbers
> https://www.acmicpc.net/problem/13144

`i번째 원소부터 차례로 볼 때 처음으로 같은 수가 등장하는 인덱스`를 `nextIndex`라고 하면 i번째부터 원소부터 시작하는 수열 중 같은 수가 여러 번 등장하지 않는 연속 수열의 개수는 `nextIndex - i개` 입니다. 이때 i+1번째 원소의 nextIndex는 i번째 원소의 nextIndex보다 항상 같거나 뒤에 있으므로, i와 nextIndex를 같은 방향으로 증가하는 투포인터로 관리할 수 있습니다.

[`CH08-09. [16472] 고냥이`](https://www.acmicpc.net/problem/16472)와 유사하게 현재 구간에 등장한 숫자를 배열 혹은 Set으로 관리하여 추가될 숫자가 unique한지 알 수 있습니다. 매번 가능한 최대 길이를 유지하며 비교하는 것으로 시간복잡도는 O(N)이 됩니다.

> ! 문제의 메모리 제한이 다른 문제의 통상적인 메모리 제한보다 작아 Scanner 사용 시 메모리 초과를 받을 수 있습니다. BufferedReader 등을 사용하여 해결할 수 있습니다.
