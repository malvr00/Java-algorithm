# [1차 캐시 (KAKAO)](https://github.com/malvr00/Java-algorithm/blob/master/programmers/level2/stap47/src/Main.java)

괄호 값이 들어있는 String p 가 주어지는데 ‘()’ 올바른괄호와, ‘)(‘ 균형잡힌괄호 문자열 두 가지가있다. p를 u와 v로 분리해야 하는데 u가 올바른괄호 또는 균형잡힌괄호가 될때까지 u에 값을 누적하고 나머지 값은 v에 누적한다. 그 후 지문에 올바른괄호 문자열 일 경우와 균형잡힌괄호 문자열 일 때의 조건을 처리해주면 된다.<br/>

<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/e9ed1127-7346-4437-a073-70018159433a" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/a7eac541-b66c-41a6-a8b2-0d7437053a2c" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>

## 해법
* 첫 번째: List로 된 배열을 만들어 준다.
* 두 번째: List로 remove 함수 실행 시 true 면 값이 존재 했기 때문에 hit 이므로 1점 누적 후 다시 List에 저장한다. ( 이러면  최신 값이 인덱스 맨 뒤로 가게 된다. )
* 세 번째: remove 함수 실행 시 false 이면 miss 이므로 5점 누적 후 List의 크기가 캐시 메모리 값 보다 같거나 클 경우 가장 오래된 데이터인 인덱스 0번 remove 후 List에 값을 저장한다.
* 네 번째: 메모리의 크기가 0으로 들어올 경우 전체 miss로 (처리해야하는 값 length) * 5 를 반환해 준다.



## 문제점
* 첫 번째: PriorityQueue로 구현하려 했으나 값의 삭제가 마땅치 않아 실패했다.
* 두 번째: 메모리 값이 0일 때 1로 변환하여 문제를 진행 했는데, 처리 해야하는 값이 연속으로 중복 시 hit 가 발생해 5점을 누적해야하는데 1점이 누적되는 현상이 있었다.
* 세 번째: Queue로도 구현이 가능할 것 같지만 삭제를 조금 더 쉽게 하기 위해 LinkedList를 선택했다.