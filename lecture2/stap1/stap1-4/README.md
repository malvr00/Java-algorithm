# [좌석 번호](https://github.com/malvr00/Java-algorithm/blob/master/lecture2/stap1/stap1-4/src/Main.java)

좌석을 몇 번째(k)에 앉을 수 있는지 찾는 문제이다. 처음 좌석 좌표 값은 [row - 1][0] 부터 시작한다. 이때 좌석을 채우는 방식은 시계방향으로 좌석을 채워나간다.<br/>

## 내가 푼 방식
* 첫 번째: k의 값이 r * c 값을 넘어 갈 경우 {0, 0}을 출력되도록 만들어 준다.
* 두 번째: cnt를 새로 할당하여 k 번째보다 작을 때 까지 좌석을 채워 나간다.
* 세 번째: pos 값 으로 위 아래로 갈지 옆으로갈지 정하는 변수를 할당한다.
* 네 번째: pos가 0 이면 위로, 1 이면 오른쪽, 2 면 아래로, 3 이면 왼쪽으로 가도록 만들어 준다.
* 다섯 번째: cnt가 k보다 같거나 커질 경우 row 값과 column 값에 1씩 더해 답을 출력한다.

<br/>

## 강의
* 첫 번째: 상하좌우 변수를 할당한다.
* 두 번째: 위치 이동 변수 값을 할당 후 cnt 가 k 보다 작을 때 까지 반복문을 반복한다.
* 세 번째: map 을 벗어나거나 map안에 값이 0 보다 클 경우 위치 이동 변수를 변경한다. 만약 map 을 벗어나지 않거나 값이 0 일 경우 cnt를 누적 시킨다.
* 네 번째: row 값과 column 값에 1씩 더해 답을 출력한다.
<br/>

## 차이점
* 첫 번째: 내 문제 풀이 방법은 상화좌우 변경 값을 모두 풀어서 작성했는데, 강의에서는 이동값을 배열로 할당해 쓸대 없는 로직을 줄여서 해결했다.