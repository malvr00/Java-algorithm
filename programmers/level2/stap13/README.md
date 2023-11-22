# [택배 상자](https://github.com/malvr00/Java-algorithm/blob/master/programmers/level2/stap13/src/Main.java)

컨베이어 벨트를 통해 상자가 배달 될 때 택배기사님이 원하는 택배상자 순서대로 넣으면서 카운트를 증가 시키는 문제이다.<br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/2a3eaa02-08a2-4d6e-9933-724c985b06db" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/c1be66f6-1484-4357-8ecd-88cf9bf2e6d4" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>

## 해법
* 첫 번째: 지문안에 ‘가장 마지막에 보조 컨테이너 벨트에 보관한 상자부터 꺼내게 됩니다’ 를 보면 Stack 문제라는 것을 알 수 있다.
* 두 번째: 택배 상자 개수 만큼 반복문을 돌 때 택배 기사님이 원하는 순서에 맞게 택배상자가 오면 카운트를 증가 시키고, 그렇지 않다면 Stack 저장되도록 만들었다.
* 세 번째: 순서에 맞게 택배상자가 왔을 때 카운트 증가와 같이 Stack도 반복해서 돌아주는데 이때 Stack 맨 위의 상자 값이 택배 기사님이 원하는 택배상자가 아니면 그대로 break 해 주고 원하는 택배상자 일 경우 카운트를 증가시키며 Stack이 비거나 원하는 상자가 아닐때까지 반복하도록 구현했다.



## 문제점
x