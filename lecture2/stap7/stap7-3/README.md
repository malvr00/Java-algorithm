# [송아지를 잡자](https://github.com/malvr00/Java-algorithm/blob/master/lecture2/stap7/stap7-3/src/Main.java)
현수의 현 재 위치와 송아지의 현재 위치가 수직선상의 좌표 점으로 주어집니다.<br/>
송아지는 매초 처음 위치에서 (이전이동거리+1)만큼 이동합니다. 송아지의 처음 이동거리는 1 입니다.<br/>
현수는 송아지를 잡기 위해 스카이 콩콩을 타고 가는데 현재 현수의 위치가 x라면 매초 앞으 로 x + 1, 뒤로 x - 1, 앞으로 x * 2 위치로 이동할 수 있습니다.<br/>
매개변수 s에 현수의 시작위치, 매개변수 e에 송아지의 시작위치가 주어지면, 현수가 송아지를 잡는 가장 빠른 시간을 반환하는 프로그램을 작성하세요.<br/>
현수의 위치와 송아지의 위치가 같으면 잡는 것으로 간주합니다.<br/>
<br/>

## 내가 푼 방식
- BFS 탐색 전 s != e 라고 지문에서 제시해줬기 때문에 e를 + count 만큼 증가시킨다.
- 큐에서 꺼낸 값을 x 그리고 앞(+ 1), 뒤(- 1), 점프(* 2) 값으로 된 변수를 만든다.
- x, 앞, 뒤 점프 값을 e와 비교해서 하나라도 같을 경우 시간을 반환한다,
  - x의 값도 비교하는 이유는 체크 배열에서 해당 x는 이미 제외시켰지면 다음 초에 송아지가 현재 x 위치로 이동할 수 있기 때문에 x도 값을 비교해준다.
- 마지막으로 송아지가 200,000을 넘길경우 -1 을 반환한다.
<br/>

## 강의
- BFS 탐색 전 2차원 체크배열을 만든다.
  - 현재 노드에서 송아지와 위치비교를 끝냈지만, 다음 초에는 송아지가 해당 위치로 이동할 수 도 있기 때문에 2차원 체크배열을 만든다.
- 현재 내 위치에서 앞, 뒤, 점프 값을 ch[count % 2][이동한 위치]에 0 일 경우 1로 변경해 체크해준다.
- 그 후 송아지 위치를 + count 만큼 증가 시킨 후 ch[count % 2][송아지 위치]의 값이 1 일 경우 해당 count를 반환한다,
- 마지막으로 송아지가 200,000을 넘길경우 -1 을 반환한다.
<br/>

## 차이점
- 강의에서는 2차원 배열을 사용해서 현재 탐색노드와 다음 탐색노드를 분리해서 확인했고, 내가 푼 방식은 큐에 담긴 현재 위치 값을 확인했다.