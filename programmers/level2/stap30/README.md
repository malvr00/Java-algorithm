# [수식 최대화 (KAKAO)](https://github.com/malvr00/Java-algorithm/blob/master/programmers/level2/stap30/src/Main.java)

String 값에 중위식으로 수식이 주어지는데 계산 연산자 우선순위를 정해 값이 가장 큰 값을 리턴하는 문제이다. 가장 큰 값을 기준으로 잡는건 절대 값으로 잡혀있다.<br/>

<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/382e2175-6dfd-4531-9739-44846d363e64" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/0cfc7bba-9fc0-452e-a2f8-645a00444204" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/e05b475c-a478-4049-907b-88da9243ed64" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>

## 해법
* 첫 번째: 연산자 ‘*’, ‘+’ ,’-‘ 저장할 배열을 먼저 만들어준 후 연산자 우선순위 경우의 수가 3! 이기때문에 dfs 모든 경우의 수를 돌아주도록 했다. 그리고 String에 들어있는 값을 연산자를 기준으로 배열에 새로 저장했다.
* 두 번째: dfs를 돌 때 ch라는 방문했는지 체크하는 변수에 true, false로 체크한다.
* 세 번째: 연산자 배열을 돌면서 계산식에서 연산자와 연산자 배열의 i번째 연산자가 같을 경우 계산식 배열에서 연산자가 있는 인덱스 (idx)를 기준으로 idx - 1, idx + 1로 연산자 양 옆의 값을 뽑아 계산 후 idx - 1 위치에 새로 set 해준 후 idx와 idx + 1 지점은 배열에서 삭제시킨다.
* 네 번째: dfs lv이 연산자 배열의 길이만큼 됐을 때 기존 answer와 절대값 수를 비교해 더 큰 수를 answer에 새로 저장한다.



## 문제점
* 첫 번째: 계산 연산이 되면 초기에 만든 배열에 업데이트 형식으로 진행했더니 백 트래킹 했을 때 배열의 초기화 이슈가 있어서 배열 초기화 기준을 다시 정했다. 그 이전에는 answer 업데이트 구간에 초기화를 했지만 문제점을 발견 후 계산이 들어가기 전에 미리 저장하고 dfs가 끝났을 때 계산식 이전에 저장해둔 배열로 초기화 시켜줬다.