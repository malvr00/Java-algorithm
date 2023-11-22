# [할인행사](https://github.com/malvr00/Java-algorithm/blob/master/programmers/level2/stap15/src/Main.java)

마트에 회원이 되면, 할인된 물품을 하루에 하나만 구매 가능한데 철수가 원하는 물건들을 10일 연속된 날에 마트에서 할인해 구매 할 수 있을 경우 회원이 될까 생각중이다. 그렇다면 회원이 될 수 있는 경우의 수를 구하는 문제이다.<br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/8719a1cb-6b15-4004-b4cd-f97f8615302b" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/17a53073-75d3-413d-a4c4-636919c05f4d" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>

## 해법
* 첫 번째: 할인물품을 기준으로 완전탐색으로 문제를 풀어나갔다.
* 두 번째: lt 라는 변수를 할당해 할인물품 구매시점을 따로 저장했다. (Slide window 활용)
* 세 번째: 할인 물품을 계속 구매하여 구매 물품에서 count를 하나씩 빼나가며 진행하다 10일 연속된 날이 됐을 때, 철수가 원하는 모든 물품을 구매 했다면 카운트를 1증가 시켰다.
* 네 번째: 10일 째 되는날 다시 연속된 일 수를 하나 빼주고(9일)  할인물품의 구매 최초 시작지점인 lt 의 물건이 자기가 구매한 물건이면 +1 시켜주고 그렇지 않으면 더해주지 않는다. 그리고 lt를 1 증가시켜 다음을 향하게 한다.



## 문제점
x