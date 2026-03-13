-- DCL 중 사용 권한을 관리

-- 사용자 권한 관리 주체
-- GRANT: 데이터 베이스 객체에 대한 권한 부여하는 질의어
-- REVOKE: 부여된 권한을 회수하는 질의어

-- 권한: 실행하거나 접근(사용)할 수 있는 권리
-- 권한 종류: 시스템 권한, 객체 권한

-- 시스템 권한
    -- DBA 권한
    -- DBA 계정에 부여
    -- DBA 권한이 있음 - 최상위 권한
    -- 사용자 생성/삭제
    -- 모든 CREATE 권한
    -- 모든 접근 권한
    -- 시스템 권한 중 일부는 일반 사용자에게 부여됨

-- 객체 권한
    -- 특정 객체를 조절할 수 있는 권한
    -- DML 관련 권한
    
/*
- ROLL
    - 사용자에게 효율적 권한을 부여하도록
    - 여러개의 권한을 묶어놓은것
    - EX. 일반 사용자의 필수 권한
        - CREATE TABLE , ALTER, DROP
        - INSERT, UPDATE, DELETE, SELECT
        - ALTER SESSION, CREATE SEQUENCE ....
        - 공통으로 필요한 권한을 ROLL로 그룹화 한후 
        - ROLL을 부여함
        - CONNECT, RESOURCE 등을 부여함
*/

-- CONNECT 롤: SESSION 권한 / CREATE 관련 권한
-- RESOURCE 롤: 사용자객체 생성 및 접근 권한에 해당되는 롤
-- DBA 롤: 슈퍼관리자 권한 (모든 권한 부여)

-- SYSTEM은 관리자 계정
-- 일반 사용자 계정 생성/수정/삭제

-- 계정 관리

-- 사용자 계정 생성
-- CREATE USER 계정명 IDENTIFIED BY "비밀번호";
ALTER SESSION sET "_ORACLE_SCRIPT" = TRUE;  -- 계정명 C## 생략하고 계정명 구성하려고 할 때 사용

-- 새로운 사용자 계정 생성
CREATE USER NEW_USER IDENTIFIED BY "1234";

-- 오라클은 사용자 계정이 DB임
-- 새로운 사용자 계정 생성 2
CREATE USER NEW_USER1 IDENTIFIED BY "1234"
    DEFAULT TABLESPACE USERS
    TEMPORARY TABLESPACE TEMP;

-- DBMS에 접속하기 위한 권한 부여해야 접속/객체 활용
-- 일반사용자 필수 ROLL 부여
-- DBMS에 접속상태를 SESSION이라고 함
GRANT CONNECT, RESOURCE TO NEW_USER1;

-- 관리자가 할당량 변경
ALTER USER NEW_USER1 QUOTA 50M ON USERS;

-- 할당량 무제한으로 설정
ALTER USER NEW_USER1 QUOTA unlimited ON USERS;

-- 사용자 계정 생성 시 테이블 스페이스 할당량 지정
CREATE USER NEW_USER2 IDENTIFIED BY 1234
    DEFAULT TABLESPACE USERS
    TEMPORARY TABLESPACE TEMP
    QUOTA 10M ON USERS;
    
GRANT CONNECT, RESOURCE TO NEW_USER2;

--------------------------------------------------------------------------------
-- 권한 회수 : REVOKE ~ FROM
-- 새로운 session을 생성하는 권한: connect
REVOKE CONNECT FROM NEW_USER2;

-- 권한 할당: GRANT ~ TO
GRANT CONNECT TO NEW_USER2;

--------------------------------------------------------------------------------
-- 사용자 계정: 객체(db)
-- 현재 비밀번호를 수정(NEW_USER2)
ALTER USER NEW_USER2 IDENTIFIED BY 1234;

--------------------------------------------------------------------------------
-- 계정 관리와 관련된 테이블 (DBA 소유) 확인

-- 현재 접속의 사용자 확인
SHOW USER;

-- 생성된 계정 정보 저장 테이블
SELECT * FROM DBA_USERS; -- DBA 권한으로 조회 (DBA 권한 없는 경우 오류)
SELECT * FROM ALL_USERS; -- 일반 유저 권한으로 조회 가능 (접근만 가능)
SELECT * FROM USER_USERS; -- 현재 사용자 권한으로만 조회 (현재 사용자 정보만 조회)

-- DBA 또는 DBA에 준하는 권한으로 확인할 수 있는 객체에 대한 정보
SELECT * FROM DBA_TABLES;

-- 특정 소유자의 객체에 대한 정보
SELECT * FROM DBA_TABLES
WHERE OWNER = 'C##SQL_USER';

SELECT * FROM DBA_TABLES
WHERE OWNER = 'C##DEVUSER10';

-- ALL_TABLES: 현재 사용자 자신이 생성한 객체와 다른 사용자가 만든 객체 중 권한이 있는 객체 검색
SELECT * FROM ALL_TABLES;

SELECT * FROM USER_TABLES;


-- 현재 계정 소유의 TABLE 확인하는 가장 간단한 퀄
SELECT * FROM TAB;

-- 사용자 계정 삭제 (오라클에서는 DB 삭제임: 신중하게 삭제를 진행하여야 함)
-- DROP USER 계정명
-- DROP USER


