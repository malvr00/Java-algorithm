# [단어 변환](https://github.com/malvr00/Java-algorithm/blob/master/programmers/level3/step28/src/Main.java)

([자세한 문제는 프로그래머스 참고](https://school.programmers.co.kr/learn/courses/30/lessons/43163)) <br/>
두 개의 단어 begin, target과 단어의 집합 words가 있습니다. 아래와 같은 규칙을 이용하여 begin에서 target으로 변환하는 가장 짧은 변환 과정을 찾으려고 합니다.<br/>
<br/>
1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.<br/>
2. words에 있는 단어로만 변환할 수 있습니다.<br/>
<br/>
두 개의 단어 begin, target과 단어의 집합 words가 매개변수로 주어질 때, 최소 몇 단계의 과정을 거쳐 begin을 target으로 변환할 수 있는지 return 하도록 solution 함수를 작성해주세요.


## 해법
* `DFS`로 탐색 `words` 탐색을 진행한다.
* `DFS` 탐색 도중 `words` 원소의 중복을 제거하기 위해 체크배열을 활용해 백트레킹으로 전체 탐색을 진행한다.
* `DFS`탐색에서 다음 뎁스로 탐색하기 위해서는 아래와 같다.
  * `begin` 단어와 `words[i]` 원소 단어와의 문자가 `하나`만 다를경우 다음 뎁스로 이동한다.
* 탐색이 완료되면 정답을 번환한다.

## 핵심
* 한 번에 한 개의 알파벳만 바꿀 수 있는 부분이 핵심 포인트다.
* `DFS, BFS` 두 가지 탐색법 모두 문제풀이가 가능하다.

## 문제점
* 맨 처음 `begin, words[i]`의 문자를 비교완료 후 예제에만 집중하여 `eQCnt >= 2` 이런식으로 문제를 해결하려 해 정답 도출이 불가능했다.
  * 두 문자가 `두 단어`만 같아도 탐색을 진행했는데, 이렇게 된면 `네 글자` 이상의 문자가 나타날 경우 문제풀이가 불가능하다.
* 문제에서 주어지는 제한사항을 자세히 확인하는 습관을 들이자.