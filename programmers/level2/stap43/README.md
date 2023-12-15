# [프로세스](https://github.com/malvr00/Java-algorithm/blob/master/programmers/level2/stap43/src/Main.java)

우선순위가 높은 값을 먼저 출력시킬 때 사용자가 원하는 location(index 위치) 위치가 몇 번째로 출력 되는지 알아내는 문제이다.<br/>

<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/2a7f574a-da95-4ca1-89ac-d67f265c3af0" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>

## 해법
* 첫 번째: location 저장 값과 우선순위 값을 저장할 수 있는 class를 하나 저장한다.
* 두 번째: Queue에 class 양식에 맞춰서 저장한다.
* 세 번째: Queue를 while으로 돌려서 location과 같으면 정답을 출력하고 같지 않을 때 현재 우선순위 값 보다 큰 값이 남아있다면 현재 값을 뒤로 보내면서 정답이 출력 될 때 까지 반복한다.


## 문제점
* 첫 번째: PriorityQueue로 처음에 구현을 했지만 location의 정렬 기준을 잡을 수 없어 실패햇다.
* 두 번째: 정답은 나왔지만 while 문안에 for문은 한번더 사용하고 있기때문에 시간 복잡도가 커지면 효율성이 떨어지므로 더 좋은 방법을 간구해봐야한다.