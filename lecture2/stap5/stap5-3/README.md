# [* 스프링 쿨러](https://github.com/malvr00/Java-algorithm/blob/master/lecture2/stap5/stap5-3/src/Main.java)
수직선상으로 표현되는 잔디밭에 스프링 쿨러가 설치되어 있습니다. 잔디밭의 길이는 0번부터 N번 위치까지 이며, 각 위치에 스프링클러가 N+1개 설치되어 있습니다.<br/>
매개변수 n에 N이 주어지고, 매개변수 nums에 0번 위치부터 N번 위치까지 N+1개의 스 풀링 쿨러의 물을 뿌리는 범위값이 차례로 주어지면 현수가 최소 몇 개의 스프링 쿨러를 작동 시키면 모든 잔디밭에 물을 줄 수 있는지 최소 스프링 쿨러의 개수를 반환하는 프로그램을 작성하세요.<br/>
모든 잔디밭에 물을 줄 수 없으면 -1를 반환합니다.
<br/>

## 내가 푼 방식
x
<br/>

## 강의
- 스프링 쿨러 배열 값 nums에 값이 주어지면 물 뿌려지는 범위 [min, max] 수직선상 좌표를 list에 저장 후 min을 기준으로 오름차순으로 정렬한다.
- 현재까지 물 뿌린 범위를 알 수 있는 값인 sT(최소 물 뿌린 지점), eT(최대 물 뿌린 지점) 각각 0으로 초기화 한다.
- sT 값과 배열 min 값을 비교 후 min 값이 같거나 작을경우 eT 지점을 max 값으로 초기화한다. ( 물 뿌린 범위 지정 )
- sT 기준으로 범위 탐색이 끝나면 answer 증가 후 eT 지점이 잔디밭 길이 n 과 같다면 종료하고, sT와 eT가 같다면 -1을 출력한다.
  - sT와 eT가 같을 때 종료하는 이유는 `{0, 2}, {3, 5}`와 같은 범위가 있을 때 `{0, 2}` 범위가 종료되면 sT = 2, eT = 2로 초기화 되는데, 이때 최소 1 또는 2 지점에 물을 뿌릴 수 있어야한다. 하지만 `{3, 5}` 범위에 물을 뿌린다면 `{2, 3}` 범위에는 물을 뿌릴 수 없기 때문에 -1로 종료한다. 

<br/>

## 문제점
- 강의 설명을 듣기 이전에는 잔디에 물을 뿌리는 지점을 점으로 생각해서 예제 [2, 0, 0, 0, 2]가 -1 이 나와야하는데 범위로 생각하지 않아 정답이 나오지 않았다.
- 
x