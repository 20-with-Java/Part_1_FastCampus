### BOJ [6198] 옥상 정원 꾸미기
> https://www.acmicpc.net/problem/6198

각 빌딩에 대해 자신보다 오른쪽에 있으면서 자신보다 큰 빌딩을 발견할 때까지 답을 더해나갈 수 있지만, 이 방법은 O(N^2)이 됩니다. 어떤 빌딩에 대해 자신을 볼 수 있는 빌딩은 자신보다 왼쪽에 있으면서 자신보다 큰 빌딩입니다. 따라서 1번 빌딩부터 자신보다 높으면서 내림차순이 될 수 있는 빌딩만 해당 빌딩을 볼 수 있습니다.

이는 [`CH02-09. [17298] 오큰수`](https://www.acmicpc.net/problem/17298)와 같이 스택을 사용해 현재 빌딩보다 높은 빌딩의 내림차순 부분 수열을 기록해나갈 수 있습니다. 모든 빌딩은 최대 한 번씩만 스택에 들어가고, 삭제될 수 있으므로 전체 시간복잡도는 O(N)이 됩니다.

이때 같은 높이의 빌딩은 볼 수 없음에 유의합니다. 또한 모든 높이가 내림차순이라면 답의 최대 범위가 N^2까지 더해질 수 있으므로 답은 `int`가 아닌 `long` 타입을 사용해야 합니다.
