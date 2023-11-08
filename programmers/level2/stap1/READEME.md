# [요격 미사일](https://github.com/malvr00/Java-algorithm/blob/master/programmers/level2/stap1/src/Main.java)

요격 미사일 개수 구하기 <br/>
<img src="https://github.com/malvr00/Java-Study/assets/77275513/b89b4551-bb32-4a3c-b114-97bcfac0aadf" width="600px" height="300px" 
  title="100px" alt="RubberDuck"></img><br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/e6fcf77f-3931-4252-91f1-d68db3eafd33" width="600px" height="300px" 
  title="100px" alt="RubberDuck"></img><br/>
  
## 해법
* 입력 값으로 (s, e) 값을 전해주고 공통 되는 값에 요격 시스템을 설치하는 문제이다. ( 발사 시작 위치 s, 타격위치 e ) <br/>
  최적의 값으로 미사일을 요격 시켜야 하고, 좌표 값으로 발사 시작 위치(s)와 타격위치(e) 값을 전해 주었기 때문에 Greedy( 그리디 알고리즘 )을 사용 했다.
* 첫 번째로 미사일 요격 할 공통 된 값을 찾아야했다. 입출력 사진을 보면 타격위치(e)의 값을 기준으로 요격 하는 힌트를 얻을 수 있었다.
* 두 번째로 요격 할 방법을 찾았으니 이제 요격 시스템이 발생 할 조건을 찾으면 된다. 먼저 값으로 주워지는 targets 값에 타격위치를 기준으로 오름차순으로 정렬했다.<br/>
  그리고 요격시스템이 마지막으로 발생한 지점 즉 타격위치(e)의 값을 따로 저장하는 변수를 할당해 저장했다.<br/>
  마지막으로 발사 시작 위치(s)가 마지막 요격미사일 보다 크거나 같다면 새로운 요격 미사일이 필요하므로 요격 미사일을 새롭게 발사( answer 값 증가 ) 후 요격미사일 지점을 새로운 타격위치(e)로 업데이트 한다.<br/>
