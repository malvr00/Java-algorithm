# [삼각 달팽이](https://github.com/malvr00/Java-algorithm/blob/master/programmers/level2/stap29/src/Main.java)

Int n 값이 주어질때 반 시계 방향으로 1 부터 값을 쌓아 반 시계 방향 기준으로 저장된 값을 출력하는 문제이다.<br/>

<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/d518b922-d337-481c-9f99-23cd5738e237" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/de386e77-e602-45ca-971f-22b46cf98863" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>

## 해법
* 첫 번째: n 값이 반복문을 돌았을때 최대 값을 구해 answer의 배열길이를 정한다.
* 두 번째: 이제 값을 쌓아야 하는데, 먼저 1,2,3,4 를 (y,0) 5, 6, 7을 (y, x)로 진행해야한다. 그리고 값을 쌓아가는 형식은 3가지 인데 일자, 대각, 아래 이렇게 3가지 경우이다.
* 세 번째: 방법이 3 개 이기때문에 3을 기준으로 x, y 값을 뽑아낸다. 3을 i로 나눴을 때 나머지가 0 인 경우면 아래로, 1 인 경우 오른쪽으로 2 인 경우 대각으로 움지이는 기준을 잡는다.


## 문제점
x