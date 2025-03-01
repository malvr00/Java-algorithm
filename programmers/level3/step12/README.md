# [(2022 KAKAO TECH INTERNSHIP) 코딩 테스트 공부](https://github.com/malvr00/Java-algorithm/blob/master/programmers/level3/step12/src/Main.java)

([자세한 문제는 프로그래머스 참고](https://school.programmers.co.kr/learn/courses/30/lessons/118668)) <br/>
당신은 코딩 테스트를 준비하기 위해 공부하려고 합니다. 코딩 테스트 문제를 풀기 위해서는 알고리즘에 대한 지식과 코드를 구현하는 능력이 필요합니다.<br/>
알고리즘에 대한 지식은 알고력, 코드를 구현하는 능력은 코딩력이라고 표현합니다. 알고력과 코딩력은 0 이상의 정수로 표현됩니다.<br/>
문제를 풀기 위해서는 문제가 요구하는 일정 이상의 알고력과 코딩력이 필요합니다.

## 해법
* DFS로도 해결이 가능할 것 처럼 보이지만 효율성 테스트가 있기 때문에 DP로 문제를 해결한다.
* 맨 처음 `problems[0][0], problems[0][1]의 최대 alp 또는 cop`의 값이 `alp, cop` 보다 클 경우가 존재하기 때문에 만약 최대 값이 더 크다면 `alp 또는 cop`를 최대 값으로 초기화 한다.
* DP의 저장 배열의 `dy[i][j]` 중 `[i]는 구해야하는 알고력`, `[j]는 구해야는 코딩력`이 각 인덱스르 담담하고 `[i][j]는 alp, cop으로 부터 [i][j]까지 소모대는 시간을 저장`
* 배열의 값을 채워나가야하는데, `dy[i + 1][j]`의 값을 현재 값과 `dy[i + 1][j]아 dy[i][j] + 1` 의 값을 비교 후 더 작은 값을 저장한다. (`dy[i][j + 1] 도 같다`)
  * `dy[i + 1][j]`의 값을 맨 처음에 값을 대입하는 이유는 `alp, cop`를 다음으로 증가시키는 맨 처음 최소값이기 때문이다.
    * 이렇게 되면 `dy[10][15]`에 `5`가 저장된다.
* `i`와 `j`가 주어진 문제의 `problems[0][0], problems[0][1]` 값 보다 클 경우 문제해결을 통해 시간을 누적한다.
  * 여기서 조건식이 몇 가지 확인해야한다.
    1. `i`, `j` 값이 `problems[0][0], problems[0][1]`의 값 보다 커야한다.
    2. `i`, `j` 값이 `최대 alp, 최대 cop` 주 값 중 어떤 값 보다 클 경우 `최대 alp, 최대 cop`에 저장한다.
       * `dy[최대 alp][최대 cop]`

## 문제점
아직도 DP 문제해결을 위한 `[i]`, `[j]` 정의를 잘 못한다... DP를 정말 많이 풀어봐야겠다. 
