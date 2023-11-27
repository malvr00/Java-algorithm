# [피로도](https://github.com/malvr00/Java-algorithm/blob/master/programmers/level2/stap20/src/Main.java)

피로도가 주워지고, 던전에 소모되는 피로도와 입장 피로도 값이 있는 2차원 배열이 주워지는데 던전을 최대로 돌 수 있는 수를 구하면 된다.<br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/bc528c2a-5467-42ad-badb-98da9983813e" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>

## 해법
* 첫 번째: 모든 던전을 체크하고 최대 값을 저장하면서 모두 탐색해야 하므로 DFS를 활용했다.
* 두 번째: 먼저 현재 피로도와 던전 돌 때 입장 피로도를 비교해 입장이 가능하다면 카운트를 1 증가한다.
* 세 번째: 모든 던전을 다 돌았을 때 현재 저장하고있는 던전을 돈 횟수와 새롭게 돈 던전 횟수를 비교해 값이 더 큰 값을 저장한다.



## 문제점
x