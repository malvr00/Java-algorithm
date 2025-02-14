# [팬린드롬 만들기](https://github.com/malvr00/Java-algorithm/blob/master/lecture2/stap9/stap9-5/src/Main.java)
앞에서 뒤로 보나, 뒤에서 앞으로 보나 같은 수열을 팰린드롬 이라고 한다. 예를 들어 {1}, {1, 2, 1}, {1, 2, 2, 1}과 같은 수열은 팰린드롬 이지만, {1, 2, 3}, {1, 2, 3, 2} 등은 팰린드롬이 아니다.<br/>
한 수열이 주어졌을 때, 이 수열에 최소 개수의 수를 끼워 넣어 팰린드롬을 만들려고 한다. 최소 몇 개의 수를 끼워 넣으면 되는지를 알아내는 프로그램을 작성하시오.
<br/>

## 푼 방식
- 먼저 1번 인덱스부터 그 다음 인덱스까지 차례로 비교한다
  - `[1][2]` -> `[2][3]` -> `[3][4]` 방식으로 값을 채워넣는다.
    - 그 이유는 `1, 2, 3`의 팰린드롬 값을 구할 때 끝 수를 제외한 `1, 2`와 첫 수를 제외한 `2, 3`의 팰린드롬 값에 `+ 1`만 해주면 팰린드롬의 값을 쉽게 구할 수 있기 때문에 `1, 2`, `2, 3`을 먼저 구해야 하는 상황이 발생하기에 대각선 방향으로 값을 채워나간다.
- 반복문을 돌면서 첫 수와 끝 수가 같다면, 중간에 끼여있는 인덱스 번호의 팰린드롬 값을 가져온다.
  - 예를들어 `2, 3, 4, 2`의 팰린드롬 값을 구할 때 이와 같이 첫 수와 끝 수가 같다면 `3, 4` 사이에 숫자 하나만 있으면 되고, `3, 4`의 팰린드롬 값은 `2, 3, 4, 2` 까지 오면서 이미 값을 구해놨기 때문에 `3, 4`의 인덱스를 가지고 구해 놓은 값을 가져온다. 
<br/>

## 문제점
- 여러 방식의 문제를 물어봐야할 것 같고, 바텀업 방식으로 구해야 하는 문제를 아직 파악하지 못한게 문제가 크다.