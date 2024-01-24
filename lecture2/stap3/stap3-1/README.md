# [최대 길이 연속수열](https://github.com/malvr00/Java-algorithm/blob/master/lecture2/stap3/stap3-1/src/Main.java)

숫자 값이 들어있는 nums 배열에서 1씩 증가하는 수열의 최대 개수를 구하는 문제이다.
<br/>

## 내가 푼 방식
* 첫 번째: nums 배열을 오름차순으로 정렬한다.
* 두 번쨰: nums의 0번 index 값을 먼저 변수 sVal에 저장한다.
* 세 번째: nums 탐색을 통해서 sVal + 1 값이 num[i] 값과 같으면 카운트를 증가시킨다.
* 네 번째: 값이 같지 않을 경우 answer에 cnt와 최대 값을 비교 후 더 큰 값을 answer에 저장한다. 그 후 cnt를 1로 초기화 해준다.
* 다섯 번째: sVal 값을 nums[I]로 초기화 한다.

<br/>

## 강의
* 첫 번째: nums 배열의 값을 Set 에 저장한다.
* 두 번째: Set 반복문을 통해 시작하는데, set.contains(x - 1) 값이 존재하면 continue 해서 다음 값을 다시 대입한다. contains를 하는 이유는 수열의 최소값을 찾기 위해서 이다.
* 세 번째: set.contains(x - 1)에 값이 존재하지 않으면 while(set.contains)문을 통해 x를 1씩 증가시키면서 수열을 카운트한다.
* 네 번째: 카운트 최대 값을 answer에 저장한다.


<br/>

## 차이점
내가 푼 방식은 nums 배열을 정렬 후 첫 번째 값을 변수에 미리 저장한다음 값을 비교해 나가고 미리 저장한 값과 다음 값이 같으면 카운트를 증가시키지 않는 방식인데 강의에서는 set을 통해 미리 중복 값을 차단 후 contains를 통해 최소값부터 탐색해 나가는 방식을 택했다. 강의와 내가 푼 문제의 차이점은 정렬 할 때와 중복 값이 많을 때 시간복잡도가 증가하는 반면 강의에서는 set으로 중복을 제거 후 contains(O(1))를 통해 시간복잡도 증가를 방지했다.
