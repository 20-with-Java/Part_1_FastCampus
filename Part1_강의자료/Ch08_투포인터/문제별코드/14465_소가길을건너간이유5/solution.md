### BOJ [14465] 소가 길을 건너간 이유 5
> https://www.acmicpc.net/problem/14465

[`CH08-04. [12891] DNA 비밀번호`](https://www.acmicpc.net/problem/12891)처럼 매번 조사해야하는 길이가 일정하기 때문에 `sliding window`로 접근할 수 있습니다. 마찬가지로 구간의 고장난 신호등의 숫자를 확인하는 것이기 때문에 꼭 `two pointer`/`sliding window`를 사용하지 않아도 누적합을 이용한 구간합을 통해서도 문제를 해결할 수 있습니다.

모든 [1:K] ~ [N-K+1:N]까지 N-K+1개의 모든 연속된 K개의 신호등 중 고장난 신호등의 개수의 최소값을 구하는 것으로 시간복잡도는 O(N)이 됩니다.
