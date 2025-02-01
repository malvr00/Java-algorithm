# [Container With Most Water](https://github.com/malvr00/Java-algorithm/blob/master/leetcode/step8/src/Main.java)

([자세한 문제는 LeetCode 참고](https://leetcode.com/problems/container-with-most-water/description/)) <br/>
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).<br/>
Find two lines that together with the x-axis form a container, such that the container contains the most water.<br/>
Return the maximum amount of water a container can store.<br/>
Notice that you may not slant the container.

## 해법
* 범위의 최대 값을 구해야하기 때문에 투 포인트 알고리즘을 활용한다.
* `lt = 0, rt = height.length - 1` 값으로 초기화한다.
  * `0 ~ height.lenght - 1`로 먼저 구하는 이유는 이 범위가 물을 담을 수 있는 최고 값이 될 수 있기 때문이다.
* `lt`가 `rt`보다 작을 때 까지 탐색한다.
* 가장먼저 범위 안에 담을 수 있는 물 값을 구한다.
  * 범위 안에 물을 담을 수 있는 값은 `min(height[lt], height[rt] * (rt - lt)`를 하면 물 값을 구할 수 있다.
* 값을 구한 후 범위를 좁혀야하는데 `height[lt]` 값이 `height[rt]` 값 보다 높이가 작다면 `lt`증가 아니면 `rt`를 증가한다.
  * 이렇게 좁히는 이유는 범위가 가장 넓을수록 많은 물을 담을 수 있지만 범위의 벽 즉 `height`의 값도 클수록 많은 물을 담을 수 있다.
* 마지막에 `answer`를 반환한다.

## 핵심
* 투 포인트 알고리즘을 활용하면서 최대 범위에서 `lt`와 `rt` 값 중 하나를 안쪽으로 이동시키면서 정답을 구해야한다.

## 문제점
* 최소 지점 즉 `0 ~ 1` 범위부터 값을 구해나갔는데 정답 도출이 힘들어 최대 범위로 생각을 바꾸어 문제를 풀었다. 