# [전력망을 둘로 나누기](https://github.com/malvr00/Java-algorithm/blob/master/programmers/level2/stap22/src/Main.java)

전력망이 연결된 그래프를 주는데 거기서 간선 하나를 잘라 전력망을 둘로 나눴을 때 송전탑 개수의 두차를 구해 가장 적은 차를 출력하는 문제이다.<br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/169b3dec-ae04-4b22-bee2-0fb963a43650" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/cf35dda2-3cf6-4351-944d-d4341a6a45e0" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>

## 해법
* 첫 번째: 먼저 간선과 간선을 서로 연결한 양방향을 배열에 새로 넣어준다. Ex) 1-3이면 [1][3] = 1, [3][1] = 1
* 두 번째: 간선이 연결된 수 만큼 반복문을 반복한다.
* 세 번째: wires을 기준으로 차례로 간선을 끊어준다. Ex) [1][3] = 0, [3][1] = 0 ( 상태가 1이면 연결 된 상태 0 이면 끈어진 상태)
* 네 번째: 간선을 끊어줬으면 BFS 호출 해 간선이 끊겼을 때 송전탑 개수를 구한 후 기존 송전탑 개수 ( 처음 시작 했을 경우 송전탑의 개수 9{n} ) - 끊어준 후의 송전탑 개수 (cnt * 2) 결과 9 - 2 하게 되면 1-3 간선이 끊어진 차인 7이 출력된다. (1-3이 끊어지면 송전탑 개수 1, 1-3을 제외한 모든 송전탑의 개수 7 )



## 문제점
* 첫 번째: 초기 전력망의 값이 단방향으로만 주어지기 때문에 양방향의 값으로 바꿔준 후 송전탑 연결된 값을 구하는게 문제였다.