# [주차 요금 계산(KAKAO)](https://github.com/malvr00/Java-algorithm/blob/master/programmers/level2/stap18/src/Main.java)

주차장의 주차요금을 계산 하는 문제인데, 입차와 출차 기록을 보고 주차요금을 출력하는 문제이다. <br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/c7489bf0-9449-4c5a-b020-803d55982860" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/afed882e-61c0-40f2-a400-6996b39aaa0a" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/315142c9-e62c-4725-b9ed-b2907f6fc2ba" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/2f4bf995-ebfd-4bdd-a86f-3abcb8e58656" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>

## 해법
* 첫 번째: 먼저 String 배열로 주어지는 값을 시간, 차량번호, 내역를 분리 후 각 3가지를 저장 할 수 있는 class 생성 후 List에 다시 저장했다. 저장하면서 Map에 차량번호를 또 따로 저장해 입차한 차량번호와 입차한 총 수를 구했다.
* 두 번째: 입차 출차 내역을 기준으로 먼저 입차 일 경우 입차 기록을 저장하고 출차의 기록이 올 경우 주차를 몇 분동안 했는지 계산했다. 만약 입차 기록만 있고, 출차의 기록이 없다면 출차 기록을 23:59로 측정해 시간계산을 진행했다.
* 세 번째: 마지막으로 주차 요금을 계산 후 완료 되면 정답 배열에 저장했다.



## 문제점
x