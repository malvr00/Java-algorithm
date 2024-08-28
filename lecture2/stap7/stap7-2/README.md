# [집으로 이동](https://github.com/malvr00/Java-algorithm/blob/master/lecture2/stap7/stap7-2/src/Main.java)
현수는 놀이터에서 놀다가 집으로 가려고 합니다. 놀이터의 위치와 집의 위치가 수직선상의 좌표 점으로 주어집니다. 놀이터는 수직선상의 0지점입니다.<br/>
현수는 놀이터에서 스카이콩콩을 타고 점프를 하면서 집으로 이동하려고 합니다.<br/>
점프는 다음과 같은 규칙으로 합니다.<br/>
1) 앞쪽으로 a만큼 이동하는 점프를 합니다. 현 지점이 5라면 앞쪽으로 3만큼 이동한다면 8지 점으로 이동합니다.<br/>
2) 뒤쪽으로 b만큼 이동하는 점프를 합니다. 현 지점이 5라면 뒤쪽으로 2만큼 점프를 한다면 3지점으로 이동합니다.<br/>
3) 뒤쪽으로 점프는 위험해서 연속으로 두 번 점프를 할 수는 없습니다.<br/>
4) 수직선상에는 점프를 해서 가면 안되는 웅덩이가 있습니다. 웅덩이지점으로는 갈 수 없습니 다.
<br/>

## 내가 푼 방식
- 탐색 전 큐에 현재 놀이터 위치인 0 을 저장한다. 그리고 수직선상 범위의 최소 값 0 과 최대 값 10,000을 만든다.
- BFS 탐색을 할 때 현재 위치 + a, 현재 위치 - b 만큼의 값을 pool에 대입해서 막혀있는 값인지 아닌지 확인한다.
- 막혀있지 않다면, 최소 값과 최대 값 범위 안에 다음 위치 값이 있다면 큐에 저장한다.
- 현재 위치 + a 값 또는 현재 위치 - b 값이 home과 같은 경우 몇 번만에 찾았는지 값을 반환한다.  
<br/>

## 강의
- 탐색 전 앞, 뒤 이동 하는 두 값을 기준으로 체크 2차원 배열을 만든다.
- pool의 값을 인덱스로 ch['앞']['pool[i]'], ch['뒤']['pool[i]'] 각각 1을 저장한다.
- 큐에 놀이터 위치 0 을 저장하고 체크 배열 앞, 뒤 0 번 인덱스에 1을 저장한다.
- BFS 탐색을 진행하면서, 현재 위치 값에 a 값을 더한 후 최대 크기인 10001 보다 작고, 체크 배열의 값이 0 일 경우만 큐에 새롭게 더한 값을 저장한다.
- 현재 위치 값에 b 값을 뺀 후 0 보다 크거나 현재 위치 값이 뒤로 이동한 값이 아니라면 큐에 저장하고 체크 배열 해당 위치에 1을 저장한다.  
- 큐 에서 꺼난 위치 값이 home과 같으면 카운트 한 값을 반환한다.
<br/>

## 차이점
- pool의 계속 탐색하는 내 방법과는 달리 강의에서는 체크 배열을 통해서 반복문을 크게 줄였다. 그리고 재탐색하는 경우도 줄였다.
  - 깊이탐색, 넓이탐색 방법은 중복 탐색하는 경우의 수를 줄이는게 중요하다