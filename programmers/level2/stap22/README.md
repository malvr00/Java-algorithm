# [전력망을 둘로 나누기](https://github.com/malvr00/Java-algorithm/blob/master/programmers/level2/stap22/src/Main.java)

n의 제곱의 배열에서 원하는 길이의 left부터 right 까지 배열 길이를 자르는 문제이다.<br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/d224ded5-8ed3-4794-a06a-93a8559cf978" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/bad2f58a-a30b-4bec-ba4f-895798bb1a33" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>

## 해법
* 첫 번째: 일단 1 2 3 / 2 2 3 / 3 3 3 이 나올 수 있도록 반복문을 만들었다.
* 두 번째: 반복문의 i의 값 나누기 n을 해서 row 의 값을 구하고, i - n * row를 해주면 ‘n이 3일 때 6 - 3 * 2’가 되면서 0~n-1 까지의 column 값이 구해진다.
* 세 번째: row 와 column 을 비교해서 row 의 값이 같거나 크면 row + 1 작으면 column + 1 해준다. 이렇게 되면 1 2 3 / 2 2 3 / 3 3 3 이렇게 만들 수 있다. ex) 2 2 3 을 보면 2가 반복되는데 row >= column 을 걸면 row 1 >= column 0 이기 때문에 2 그 다음 row 1 >= column 1 -> 2 2, row 1 >= column 2 -> 2 2 3



## 문제점
* 첫 번째: 맨 처음에는 2차원 배열에 미리 값을 입력 후 left 부터 rigth 까지 데이터를 출력하려 했으나, n의 값이 최대 10^6까지 가능 하기 때문에 2차원 배열을 돌릴 수 없었다.
* 두 번째: 반복문을 한번만 반복되도록 수정 후 2차원 배열에 저장하려 했던 값을 정답출력 배열에 바로 저장해 출력했다. 