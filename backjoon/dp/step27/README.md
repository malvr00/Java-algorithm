# [공통 부분 문자열](https://github.com/malvr00/Java-algorithm/blob/master/backjoon/dp/step27/src/Main.java)
두 문자열이 주어졌을 때, 두 문자열에 모두 포함된 가장 긴 공통 부분 문자열을 찾는 프로그램을 작성하시오.<br/>
<br/>
어떤 문자열 s의 부분 문자열 t란, s에 t가 연속으로 나타나는 것을 말한다. 예를 들어, 문자열 ABRACADABRA의 부분 문자열은 ABRA, RAC, D, ACADABRA, ABRACADABRA, 빈 문자열 등이다. 하지만, ABRC, RAA, BA, K는 부분 문자열이 아니다.<br/>
<br/>
두 문자열 ABRACADABRA와 ECADADABRBCRDARA의 공통 부분 문자열은 CA, CADA, ADABR, 빈 문자열 등이 있다. 이 중에서 가장 긴 공통 부분 문자열은 ADABR이며, 길이는 5이다. 또, 두 문자열이 UPWJCIRUCAXIIRGL와 SBQNYBSBZDFNEV인 경우에는 가장 긴 공통 부분 문자열은 빈 문자열이다.

([자세한 문제는 백준 참고](https://www.acmicpc.net/problem/5582)) <br/>

## 해법 1
* 두 문자열 `A, B`의 각각의 길이를 2 차원 배열로 `dp[A.length()][B.length()]` 배열을 생성한다.
  * 행은 `A` 문자열의 `ith` 까지의 문자를 담당한다.
  * 열을 `B` 문자열의 `jth` 까지의 문자를 담당한다.
* `A.length() * B.length()` 만큼 반복문을 탐색하면서 점화식을 실행한다.
* 점화식은 아래와 같다.
  * `if(A.chatAt(i - 1) == B.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1`
    * `A`와 `B` 문자가 같다면 현재 `i` 위치와 `j`위치의 문자를 제거했을 때도 이전 문자들이 부분 문자열(현재를 제외한 문자열이 서로 이어져있는지 확인)이 되는지 확인하고 `+ 1` 해준다.
  * `else dp[i][j] = 0`
    * `i`와 `j` 위치까지의 문자가 같지 않다면 연결을 끊어주기 위해서 `0`으로 초기화한다.
* 마지막으로 `dp[i][j]`의 값 중 가장 큰 값을 반환한다.

## 핵심
* 인덱스의 정의가 중요하며, `A`와 `B` 문자가 서로 다를 경우 연결을 끊어주는게 중요하다.
* LCS 방식을 활용하면 문제를 쉽게 풀 수 있다.

## 문제점
* 처음에 LCS 방식으로 풀었는데 LCS는 연속적이지 않아도되는 문제기 때문에 한번 연결된 문자들은 계속 연결되어 있는 상황이 발생하는데 해당 문제에서는 연결을 끊어야하는 점을 간과했다.