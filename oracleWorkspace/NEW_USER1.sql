-- 현재 사용자에게 할당된 공간에 대한 정보 반환
-- 현재 접속에 대한 정보만 반환함
SELECT * FROM USER_TS_QUOTAS;

SHOW USER;

-- 생성된 계정 정보 저장 테이블
SELECT * FROM DBA_USERS; -- DBA 권한으로 조회 (DBA 권한 없는 경우 오류)
SELECT * FROM ALL_USERS; -- 일반 유저 권한으로 조회 가능 (접근만 가능)
SELECT * FROM USER_USERS; -- 현재 사용자 권한으로만 조회

-- 
SELECT * FROM DBA_TABLES;