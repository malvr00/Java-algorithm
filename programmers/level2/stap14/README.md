# [연속 부분 수열 합의 개수](https://github.com/malvr00/Java-algorithm/blob/master/programmers/level2/stap14/src/Main.java)

하나로 이어진 수열이 있다는 가정하에 1장부터 주어진 값의 배열 길이만큼 숫자를 뽑아서 합 했을 경우 합의 숫자가 중복되지 않는 개수를 구하는 문제다.<br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/506207da-47e0-4d56-b92f-7a4000eb9a1d" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/0135d8ad-0ed5-42cd-bb42-7d099fdb26b7" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/afca5069-7dcd-4f06-bdc0-68aa84677b7f" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>

## 해법
* 첫 번째: 카드를 몇 장 뽑을지 선택하는 반복문 하나, 뽑은 카드를 합할 반복문 하나 총 2개를 사용해 문제를 해결했다.
* 두 번째: 숫자를 뽑아 합 했을때 중복된 값을 거르기위해 Set을 사용했다.



## 주의점
* 첫 번째: Set을 사용하지 않고 List를 통해 저장하면 중복현상을 막을 수 없고, List의 contains를 활용한다면 contains의 시간복잡도는 O(n)이기 때문에 시간 초과가 날 수 있다.