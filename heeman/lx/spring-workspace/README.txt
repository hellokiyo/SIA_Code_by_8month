1. spring 플러그인 다운
help-eclopse marketplace -search(spring 검색) -클릭없이 그냥 쭉쭉 진행하

2. file -new - project - maven project - next - Group Id : huongdanjava,  Artifact Id : huongdanjava-springmvn-archetype,  version : 2.1.2 선택후 next


Group ID : lx/edu(일종의 패키지 같음)
Artifact Id : spring(일종의 프로젝트 명같음)

쭉 next하고 설치기다리다가 콘솔창에 Y뜨면 Y치고 enter
(에러날탠데 서버가 연결이 안되어있는거임 연결해주면 해결!)

server 연동
톰켓 10.1버전 연결해주기

개발 환경 구축
tomcat server 10.1.44
eclips 24.9
jdk 17(21?)



서버 만들고 해야할 것 
Build Path에서 ClassPath에 server 추가하기
 
Project facets 
java - 21
dinamic web - 5.0

Runtimes에서 내가 만든 서버 연결해주기




