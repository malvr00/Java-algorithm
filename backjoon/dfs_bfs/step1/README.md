# [DFS와 BFS](https://github.com/malvr00/Java-algorithm/blob/master/backjoon/dfs_bfs/step1/src/Main.java)
그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.

([자세한 문제는 백준 참고](https://www.acmicpc.net/problem/1260)) <br/>

## 해법
* 먼저 주어지는 `노드 개수 = N` 크기만큼 배열을 미리 만들어서 양방향으로 값을 넣어줄 준비를 한다.
  * `List<ArrayList<Integer> list = new ArrayList<>();` 기본 배열을 사용해도 되지만 사용이 편하려고 `Object` 채택했다.
* `간선의 개수 = M` 값이 오면 `M` 크기만큼 양방향에 값을 미리 생성산 배열에 값을 넣는다.
  * `list.get(M[0]).add(M[1]), list.get(M[1]).add(M[0])` 양방향으로 값을 넣어준다.
* 값 세팅이 끝나면 문제에서 번호가 작은 것을 먼저 방문해야 한다고 했기 때문에 연결되어있는 노드 목록을 오름차순으로 정렬한다.
* `DFS, BFS` 호출을 하면되는데, `DFS`는 간선이 연결된 `list`를 활용해서 재귀호출 함수를 만들어준다. `BFS`는 `Queue`를 활용해서 넓이 탐색이 가능하도록 한다.
  * `DFS(ROOT, 노드 연결 리스트, 방문확인 배열(재방문 방지), 방문한 노드 저장할 문자열)`
    * `DFS` 함수 점화식은 `for(Integer node : list.get(root)){ if(ch[node]) continue; DFS(node, list, ch, sb)}`
  * `BFS(ROOT, 노드 연결 리스트, 방문확인 배열(재방문 방지), 방문한 노드 저장할 문자열)`
    * `BFS` 함수 점화식은 `while(!q.isEmpty()) {int root = q.poll(); for(Integer node : list.get(root)){ if(ch[node]) continue; ch[node] = true; q.offer(node);}}`
* 마지막에 각자 선택한 문자열 형식에 저장된 값을 반환한다.

## 핵심
* 노드들은 양방향으로 연결되어있고, 양방향 연결된 노드를 어떻게 저장할지 방식을 잘 생각하면 쉽게 풀 수 있다.

## 참고
* `DFS, BFS` 재활 문제로 좋은 문제같다.
