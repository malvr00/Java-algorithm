# [소수 찾기](https://github.com/malvr00/Java-algorithm/blob/master/programmers/level2/stap40/src/Main.java)

String으로 숫자 값이 넘어오는데 한 개의 숫자로 찢어서 조합 후 그 수가 소수라면 카운트를 증가시키는 문제이다.<br/>

<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/112c711d-3284-4836-8a3c-319ff2c834d1" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>

## 해법
* 첫 번째: 경우의 수 중복을 막기위해 ch 배열과 set을 추가한다.
* 두 번째: 파라메터 값에 들어온 수가 소수인지 판별하는 함수를 만든다.
* 세 번째: DFS를 돌면서 소수판별 함수를 호출 후 true 라면 카운트를 늘려준다.


## 문제점
* 첫 번째: 중복 숫자 거르는 방법을 set을 활용했는데 이 set 변수를 소수판별 함수에만 적용시켜 중복숫자를 거르고 있다. 복잡도가 크지않아 이러한 방식을 채택했지만 복잡도가 높아진다면 DFS에 도입하여 복잡도를 최소화 시켜야 할 것 같다.