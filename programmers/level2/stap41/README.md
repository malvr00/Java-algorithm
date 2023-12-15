# [H-Index](https://github.com/malvr00/Java-algorithm/blob/master/programmers/level2/stap41/src/Main.java)

논문 인용횟수를 h 로 정했을 때 h 이하, h 이상의 논문이 인용된 값 중 최대 h 값을 찾아내는 문제이다.<br/>

<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/272c0850-fbb6-4262-a18d-3b2bdcdde38d" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>

## 해법
* 첫 번째: 논문 인용 정보가 들어있는 배열을 정렬해준다.
* 두 번째: 인용 0 회 부터 인용정보의 최대 값 까지 반복문을 돌아준다. ( 변수 명을 h로 선정 )
* 세 번째: 논문 이용정보와 비교하여 h 이하인 값을 카운트 해준다.
* 네 번째: h 이상의 값이 됐다면 비교를 중지하고 기존에 저장되있는 h 값과 비교해 더 큰 h 값을 저장한다.


## 문제점
x