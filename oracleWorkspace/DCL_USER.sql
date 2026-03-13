SELECT * FROM USER_TS_QUOTAS;

-- 현재 접속의 사용자 확인
SHOW USER;

-- 생성된 계정 정보 저장 테이블
SELECT * FROM DBA_USERS; -- DBA 권한으로 조회 (DBA 권한 없는 경우 오류)
SELECT * FROM ALL_USERS; -- 일반 유저 권한으로 조회 가능 (접근만 가능)
SELECT * FROM USER_USERS; -- 현재 사용자 권한으로만 조회 (현재 사용자 정보만 조회)




SELECT * FROM DBA_TABLES;
SELECT * FROM ALL_TABLES;
SELECT * FROM USER_TABLES;

-- 일반 사용자 소유 객체에 대한 권한

-- 1. 일반 사용자 NEWUSER2가 C##SQL_USER 소유의 테이블에 접근하기 위해 아래 쿼리를 실행
SELECT * FROM book; -- 테이블명만 쓰면 현재 접속 사용자의 소유라는 의미임
SELECT * FROM C##SQL_USER.book; -- book 테이블의 소유주를 표현해서 어디서 찾아올 것인지 명시
-- ORA-00942: 테이블 또는 뷰가 존재하지 않습니다 오류: 생성했는데 테이블명 오타가 있는 경우, 접근 권한이 없는 경우
-- NEWUSER2가 book 테이블을 사용하려면 소유주한테 접근 권한을 받아야 함

-- 2. book 테이블 소유자인 C##SQL_USER가 book 테이블에 대한 권한을 NEW_USER2에게 줘야 함
-- system은 book 테이블의 소유주가 아니므로 접근 권한 줄 수 없음
-- 계정 C##SQL_USER로 접속
-- 테이블에 대한 권한: INSERT/UPDATE/DELETE/SELECT(조회) ALTER/DROP
GRANT SELECT ON book TO NEW_USER2;

-- 3. NEW_USER2 계정에서 사용
SELECT * FROM C##SQL_USER.book;
-- 다른 소유주의 테이블 데이터 수정
UPDATE C##SQL_USER.book SET pubNo = '2' WHERE bookNo = '1001'; -- 권한이 불충분 합니다 

-- 4. book 테이블 소유주가 UPDATE 권한 부여
-- C#SQL_USER로 접속 변경
GRANT UPDATE ON book TO NEW_USER2;

-- 5. NEW_USER2 계정에서 UPDATE 진행
SELECT * FROM C##SQL_USER.book;
UPDATE C#SQL_USER.book SET pubNo = '2' WHERE bookNo = '1001';
SELECT * FROM C##SQL_USER.book;

-- 모든 객체의 권한은 소유주가 설정한다
-- 6. NEW_USER2 계정에 부여했던 권한 회수 (소유주가 진행)
-- C##SQL_USER 접속에서 진행
REVOKE SELECT ON book FROM NEW_USER2; -- 권한의 회수는 즉시 적용됨