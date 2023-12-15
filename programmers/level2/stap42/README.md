# [가장 큰 수](https://github.com/malvr00/Java-algorithm/blob/master/programmers/level2/stap42/src/Main.java)

Int 배열에 값을 [6, 10, 2] 를 주어졌을 때 원소의 수를 조합해 가장 큰 수를 만들어내는 문제이다.<br/>

<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/d360daa9-7d9f-414e-b0d3-a5ac73accb81" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>

## 해법
* 첫 번째: Int 배열을 String 배열로 변환해준다.
* 두 번째: String 배열로 변환 후 정렬을 해줘야하는데, o2+o1 으로 String 값을 합해 하나의 정수로 만들어 주고 o1+o2 와 값과 비교해 정렬해준다.
* 세 번째: 정답을 출력할 때 첫 번째 글자가 “0” 이면 0이 출력되도록 해준다.


## 문제점
* 첫 번째: 몫을 기준으로 내림차순과 몫이 같을 때 나머지 값을 기준으로 내림차순으로 기준으로 정렬, 나머지 값도 같을 때 원소의 길이를 비교해 원소의 길이 기준으로 오름차순으로 정렬해 주었다. 그 결과 [3, 34], [7, 71] 과 같은 값은 정렬이 원하는 결과로 나오지 않았다. ( 343, 717 출력 )
* 두 번째: 정렬을 단순화 하여 문제를 해결했다. 기존의 정렬 방식을 지우고 현재 위치의 원소와 다음 원소를 합해 더 작을 때 오름차순이 되도록 만들어줘 문제를 해결했다.