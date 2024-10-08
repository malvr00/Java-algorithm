# [* 팰린드롬의 경우 수](https://github.com/malvr00/Java-algorithm/blob/master/lecture2/stap6/stap6-4/src/Main.java)
매개변수 s에 문자열이 주어지면 이 문자열의 모든 문자들을 가지고 만들 수 있는 팬린드롬의 경우들을 배열에 담아 반환하는 프로그램을 작성하세요. 각 팰린드롬을 배열에 담는 순서는 상관없습니다.<br/>
만약 팰린드롬이 만들어 지지 않을 경우 빈배열을 반환합니다.
<br/>

## 내가 푼 방식
- 문자열 s를 DFS 탐색을 통해서 전체를 탐색한다.
- 마지막으로 팰린드롬인지 확인 후 맞다면 HashSet에 저장한다.
<br/>

## 강의
- 문자열 s에 중복된 문자가 얼마나 있는지 HashMap에 저장한다.
- HashMap에서 중복된 문자가 2 개 미만인 문자를 찾는다.
  - 만약 2 개 미만인 문자가 2 개 이상일 경우 팰린드롬이 될 수 없음으로 빈 배열을 출력
  - 2 개 미만인 문자가 2 개 미만일 경우 데크에 저장 후 카운트를 0 으로 바꿔준다.
- DFS 탐색을 돌면서 HashMap에 저장되있는 키의 값이 0 이상일 경우 데크 양 끝으로 값을 저장한 후 HashMap에서 해당 키의 value를 2 뺀다.
- 끝 까지 탐색을 했을 때 정답 배열에 추가하고, 노드를 제거할 때 데크 양 끝 값을 제거 후 해당 키의 value를 2 증가시킨다.
<br/>

## 문제점
- 내가 푼 방식의 문제는 중복된 탐색도 많이하고, 팰린드롬이 될 수 없는 값도 끝까지 탐색하는 문제가 있다.
- 강의에서는 팰린드롬이 될 수 없는 경우, 팰린드롬이 되는 경우의 중점을 잘 잡아 탐색 최적화를 진행했다.
  - 팰린드롬 형식의 문제가 나온다며, 문제푸는 핵심을 잊지 않아야겠다.