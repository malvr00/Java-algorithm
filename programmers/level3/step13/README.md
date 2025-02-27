# [(2022 KAKAO BLIND RECRUITMENT)파괴되지 않은 건물](https://github.com/malvr00/Java-algorithm/blob/master/programmers/level3/step13/src/Main.java)

([자세한 문제는 프로그래머스 참고](https://school.programmers.co.kr/learn/courses/30/lessons/92344)) <br/>
N x M 크기의 행렬 모양의 게임 맵이 있습니다. 이 맵에는 내구도를 가진 건물이 각 칸마다 하나씩 있습니다. 적은 이 건물들을 공격하여 파괴하려고 합니다. 건물은 적의 공격을 받으면 내구도가 감소하고 내구도가 0이하가 되면 파괴됩니다. 반대로, 아군은 회복 스킬을 사용하여 건물들의 내구도를 높이려고 합니다.<br/>

## 해법
* 단순 반복문으로 문제를 해결할 경우 시간 초과가 발생하기 때문에 imos 알고리즘을 활용한다.
* `board.length, board[i].length`보다 1 큰 2 차원 배열 `dy`를 생성한다.
* `skill` 값이 주어지면 `skill`의 `r1,c1, r2, c2` 기준 1 사이즈 큰 모서리에 `degree` 값을 imos 알고리즘에 맞게 쌓는다.
* `skill` 탐색이 끝나면 값이 누적된 `dy` 배열을 먼저 열 값들을 `합 연산`한다.
* 열 계산이 끝나면 행 값을 `합 연산` 한다.
* 마지막으로 `board[i][j]`와 `dy[i][j]` 값을 더해 `0 < val` 일 경우 `answer`를 1 증가시킨 후 정답 리턴

## 문제점
단순 반복문으로 문제를 해결할 경우 `O(m*n*s)` 시간 복잡도를 가져 시간 초과가 발생할게 보인다.<br/>
이를 해결하기위해 주어진 범위를 `O(1)`로 값을 채워나가야 하는데 방법을 찾아보던 중 imos 알고리즘을 알게되어 문제를 해결했다. (여러모로 많이 쓰일 알고리즘 같으니 잊지말고 기억하자.)<br/>
