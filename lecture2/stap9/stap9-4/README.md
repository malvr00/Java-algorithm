# [* 등차수열](https://github.com/malvr00/Java-algorithm/blob/master/lecture2/stap9/stap9-4/src/Main.java)
N개의 음 아닌 정수들이 있다. 이들 중 몇 개의 정수를 선택하여 나열하면 등차수열을 만들 수 있다. 예를 들어 4, 3, 1, 5, 7이 있을 때 1, 3, 5, 7을 선택하여 나열하면 등차수열이 된다. 이와 같이 했을 때, 등차수열의 길이가 최대 얼마까지 가능한지 알아내시오.<br/>
등차수열은 일정한 값만큼 증가하는 수열을 말한다. 이 일정한 값은 음수나 0도 될 수 있다.
<br/>

## 푼 방식
- 먼저 배열 score 값을 오름차순으로 정렬한다.
- 정렬을 진행 한 후 score.length 길이 만큼의 2 차원 배열을 만든다.
  - 각 원소들에 대해 값을 차례로 누적하기 위해서 2차원 배열을 진행했다.
- 탐색을 진행할 때 반복문을 `i 부터 score.length - 2` 만큼 돌고, 다음 반복문은 `i + 1부터 socre.length - 1` 돌면서 전체 탐색을 진행한다.
- 먼저 원소의 값이 2 개 이상일 경우는 최소 한 쌍이 존재하기 때문에 베이스 값을 2로 잡는다.
- 그 후 `score[j] - score[i]` 값을 빼서 공차 값을 구한 후 만약 'i' 이전 값이 존재할 경우 즉 `k = i - 1` 값 원소 값이 있다면, 역으로 반복문을 돌면서 `score[i] - score[k]` 값이 `score[j] - score[i]` 값과 같을경우 등차수열이기 때문에 `i와 k 값` 만큼의 카운트 값인 `dy[k][i]` 값을 1 더한 값을 `dy[i][j]` 값에 대입한다.
- 마지막으로 answer와 dy[i][j] 비교 후 더 큰 값을 answer에 저장한다.
<br/>

## 문제점
- DP 방식으로 문제접근하기 매우 어려웠다.