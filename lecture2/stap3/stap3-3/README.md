# [현관문 출입순서](https://github.com/malvr00/Java-algorithm/blob/master/lecture2/stap3/stap3-3/src/Main.java)

현관문을 나가거나 들어올 수 있는 인원 수는 1명으로 제한되어있는데 각 사원 별로 몇 초에 나가거나 들어올 수 있는지 기록 후 출력하는 문제이다. Arrival 에는 각 사원 번호 별 현관문에 도착한 시간, state 에는 1이면 나가는 사원, 0이면 나가는 사원이다.
<br/>

## 내가 푼 방식
* 첫 번째: arrival.length 를 기준으로 탐색을한다.
* 두 번째: 첫 번째 조건식으로 1초 전에 현관문을 사용하지 않았으면 무조건 나가는 사원 먼저 나가야 하기 때문에 초기 값으로 prev 변수에 1을 할당한다. 현관문 출입 초기 시간 값 time을 arrival[0] 값으로 초기화 한다.
* 세 번째: 현관문의 출입 간격이 큰 경우가 있는데 ( ex. 5초, 6초, 7초 이런식으로 출입 기록이 없을 수 있음 ) 그럴 경우 현재 arrival[i]의 시간 값으로 time을 초기화 후 첫 번째 조건식에 1초 전에 현관문 사용을 안하면 1로 초기화 해야 하기 때문에 prev를 1로 초기화 한다.
* 네 번째: 현관문 출입한 기록을 가지고 현재까지의 time 보다 같거나 작은 기록을 저장하는데 이때 해당 사원의 state 값이 0이면 enterQ, 값이 1이면 exitQ에 각각 Queue 변수에 넣어준다.
* 다섯 번째: enterQ와 exitQ의 기록이 모두 존재하면 이전에 기록한 prev 값을 사용하고, 하나의 Queue에만 존재 한다고 했을 때 enterQ에 값이 없으면 prev를 1로,  exitQ에 값이 없으면 prev를 0으로 초기화한다.
* 여섯 번째: prev에 맞게 Queue에서 데이터를 꺼내와 answer에 값을 누적시킨다.

<br/>

## 강의
x


<br/>

## 문제점
지문에 조건을 제대로 파악하지 못 해서 문제를 풀어나가는데 어려움이 있었다. 그리고 순서대로 출력해야하거나, 줄을 세워서 출력해야 하는 경우는 Queue 자료구조를 사용하면 간편하게 문제를 해결 할 수 있다.
