요구사항

아래 명령어를 처리하는 간단한 버전관리 시스템을 구현하라.

명령어
	•	init
저장소 초기화. 브랜치 main 생성, HEAD는 main을 가리킴. working/staging 비움.

	•	add <file> <content...>
working의 <file> 내용을 <content>로 설정하고 staging에 “추가/수정”으로 기록한다.
(content는 공백 포함, 줄의 나머지 전체)


	•	rm <file>
working에서 <file> 삭제하고 staging에 “삭제”로 기록한다.


	•	commit <message...>
staging을 반영한 스냅샷 커밋 생성. 커밋 id는 c1, c2, ... 순서.
HEAD가 가리키는 브랜치(main) 포인터가 새 커밋을 가리키게 한다.
commit 후 staging 비움.


	•	checkout <name>
<name>이 main이면 main 브랜치로 이동(HEAD attached)하고 working을 main의 커밋 상태로 복원한다.
<name>이 커밋 id면 detached HEAD로 이동하고 working을 해당 커밋 스냅샷으로 복원한다.
checkout 후 staging 비움.


	•	log
HEAD에서 시작해 부모를 따라가며 commitId message를 한 줄씩 출력한다.


	•	cat <file>
working에서 파일 내용을 출력. 없으면 빈 줄 출력.


	•	quit 종료

규칙
	•	커밋은 “파일명→내용”의 전체 스냅샷이다.
	•	checkout은 working을 “해당 커밋 스냅샷 그대로”로 만든다(기존 working 내용은 사라짐).

⸻

입출력

표준입력으로 명령이 한 줄씩 들어오며, 출력은 log, cat만 한다.