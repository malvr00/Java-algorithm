# [기능개발](https://github.com/malvr00/Java-algorithm/blob/master/programmers/level2/stap44/src/Main.java)

프로세스 개발 진행도 배열과 개발속도 배열 두 개가 주어지는데, 개발진행 중인 프로세스의 개발속도를 확인하여 한번에 몇 개의 프로세스가 배포 되는지 체크하는 문제이다.<br/>

<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/0c5cd215-3e70-4b89-8701-0cf40c9729dd" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>

## 해법
* 첫 번째: Queue에 프로세스들의 개발 완료되는 시간비례 카운트를 저장한다.
* 두 번째: Queue에 값이 없을 때 까지 반복문을 반복해 앞의 개발 카운트보다 뒤에 있는 프로세스의 개발 카운트가 같거나 작다면 앞의 프로세스와 같이 배포 됐기 때문에 배포카운트를 늘려준다.


## 문제점
x