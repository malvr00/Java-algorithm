# [행렬 테두리 회전하기](https://github.com/malvr00/Java-algorithm/blob/master/programmers/level2/stap25/src/Main.java)

Queries 2차원 배열 안에 y1행 x1 열, y2 행 x2 열 값이 주워질 때 y1 ~ y2, x ~ x2 까지 360도 한번회전 후 회전 한 값 중 가장 작은 수를 정답 배열에 저장 후 리턴 해 주면 되는 문제이다.<br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/92beaafd-2930-47cf-91e9-99505fd884ec" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/7f7cbb9f-62cd-43fc-a466-cbdf61d90b57" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/a3e9065e-f85a-4b44-abf0-dc8a58022e83" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>

## 해법
* 첫 번째: rows와 columns 기준으로 새로 arr 배열을 만들어 값을 넣어준다.
* 두 번째: queries 기준으로 반복문을 돌면서 y1 x1, y2 x2 값을 뽑아낸다.
* 세 번째: 지정된 범위를 360도 회전시켜 그 중 값이 가장 낮은 값을 정답 배열에 저장한다.



## 문제점
* 첫 번째: 360도 회전 할 때 걸리는 사항이 있다. 360도 회전은 잘 되나 코드가 썩 보기 좋지 않아 Queue를 활용하거나, 더 좋은 방법이 있는지 생각해봐 한다.