# [불량 사용자(KAKAO)](https://github.com/malvr00/Java-algorithm/blob/master/programmers/level3/step23/src/Main.java)

([자세한 문제는 프로그래머스 참고](https://school.programmers.co.kr/learn/courses/30/lessons/64064)) <br/>
이벤트 응모자 아이디 목록이 담긴 배열 user_id와 불량 사용자 아이디 목록이 담긴 배열 banned_id가 매개변수로 주어질 때, 당첨에서 제외되어야 할 제재 아이디 목록은 몇가지 경우의 수가 가능한 지 return 하도록 solution 함수를 완성해주세요.

## 해법
* `user_id`를 기준으로 중복되지 않는 조합 경우의 수를 모두 찾는다.
  * 조합을 찾을 때 `user_id` 원소에는 중복 값이 없기 때문에 `banned_id`의 길이만큼 유저를 저장할 때 `Set`을 활용해서 저장한다.
* `banned_id` 길이만큼의 유저를 조합을 찾았다면 차단 시켜야 할 유저를 찾는다.
  * `banned_id`의 원소들을 중심으로 조합한 유저의 아이디의 벤 경우의 수를 모두 찾는다.
    * 벤 경우의 수를 모두 찾는 이유는 `user = {aab, abb}`, `ban = {a*b, aa*}` 이럴 경우 벤 해야하는 유저를 놓칠 수 있는 경우가 생기기 때문에 모두 탐색한다.
* 조합한 유저들을 모두 벤할 경우 `answer`에 카운트를 늘려주고 탐색이 끝나면 `answer`를 반환한다.

## 핵심
* 주어지는 배열의 길이가 짧기 때문에 조합을 활용해 문제를 풀어나가야한다.

## 문제점
* 맨 처음 문제를 풀었을 때 유저의 조합을 찾고 벤 검증을 할 때 유저를 기준으로 `banned_id`를 탐색했는데 통합 테스트에서 3 개를 통과하지 못했다.
  * 유저를 기준으로 벤 목록을 탐색할 경우 카운팅을 놓치는 경우가 생겨서 검증을 할 때 기준을 어디에 두고 할 지 생각을 잘 해야한다.