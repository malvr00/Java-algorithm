# [동전 2](https://github.com/malvr00/Java-algorithm/blob/master/backjoon/dp/step17/src/Main.java)
n가지 종류의 동전이 있다. 이 동전들을 적당히 사용해서, 그 가치의 합이 k원이 되도록 하고 싶다. 그러면서 동전의 개수가 최소가 되도록 하려고 한다. 각각의 동전은 몇 개라도 사용할 수 있다.

([자세한 문제는 백준 참고](https://www.acmicpc.net/problem/9461)) <br/>

## 해법
* `K + 1` 크기만큼 배열을 만든다.
  * 동전의 최소값을 구해야하기 때문에 배열의 값들을 `Integer.MAX_VALUE`로 초기화한다. 
* `N^K` 크기 만큼 반복문을 돌면서 배열에 사용되는 최소의 동전 개수를 누적한다.
* 점화식은 `dp[i] = min(dp[i], dp[i - coin] + 1)`이다.
  * 여기서 중요한 점은 `도달불가` 값 인데 `Integer.MAX_VALUE + 1`되는 현상을 막기위해 `if(dp[i - coin] != Integer.MAX_VALUE)` 일 경우만 점화식을 실행한다.
    * `도달불가` 상태가 되는 이유는 `coin = 5` 만 존재하고 `i = 6` 일 때 `dp[i - coin] = Integer.MAX_VALUE`에 `+ 1` 하는 현상이 발생해서 `INF` 값을 초과하는 경우가 발생한다.

## 핵심
* `도달불가` 상태를 조심해야하며, 최소 값을 구할 때 `Integer.MAX_VALUE`를 활용해도 되지만 `INF` 값을 주어진 값 즉 `K`를 활용해서 `K + 1`을 `INF` 값으로 활용하는게 문제푸는데에 있어서 더 편할 수 있다.

## 문제점
