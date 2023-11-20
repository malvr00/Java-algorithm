# [롤케이크 자르기](https://github.com/malvr00/Java-algorithm/blob/master/programmers/level2/stap11/src/Main.java)

형제의 케이크를 나눠야 하는데, 케이크 위에 올라간 토핑의 종류 수가 같으면 카운트를 증가시키는 문제인데 토핑의 종류가 같을 수 있는 경우의 수를 구하는 문제이다.<br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/8a68476b-12f5-4aab-93ac-a4b442c6acd3" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>

## 해법
* 첫 번째: 형의 케이크 위에 올라가있는 토핑을 Map에 저장하고, 동생의 케이크 위에 올라가있는 토핑을 동생 Map에 저장한다. Map을 구하는 범위는 형은 lt 0, rt 0 으로 시작하고, 동생은 lt1, rt topping.length - 1 에서 시작했다.
* 두 번째: 이제 동생에 있는 토핑을 형의 토핑으로 옮기는 작업을 토핑의 총 개수만큼 반복해 주면 된다.
* 세 번째: 형의 토핑이 하나 증가하면 Map에 새롭게 추가해주고, 동생의 Map에서는 토핑 하나를 빼주는데 그때 동생의 토핑의 값이 0 이라면 Map에서 토핑을 제거 시켜준다.
* 네 번째: 토핑 추가 작업이 끝나면, 형 Map과 동생의 Map의 사이즈를 비교해 크기가 같다면 카운트를 1증가 시켜준다.




## 문제점
x