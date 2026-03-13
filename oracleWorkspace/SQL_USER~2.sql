-- 테이블 제약조건 확인 쿼리
-- 일반 계정에서 접근(확인) 가능함
-- USER_CONSTRAINTS: 해당 USER의 소유테이블의 모든 제약조건 확인

SELECT * FROM USER_CONSTRAINTS;
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME='BOOK';

/*
    DUAL 테이블
    : 시스템이 제공하는 기능(함수) 사용하기 위한 오라클이 제공하는 테이블
    1개의 행과 1개의 열만 있는 DUMMY 테이블
    SYS 소유지만 모든 사용자가 접근 가능
    
    용도
    : 간단하게 함수를 이용해서 계산 결과값 확인
    함수 결과 확인을 위해서는 SELECT 절을 사용해야 함
    SELECT ~ FROM 이 기본 구조임
    SELECT 함수식 FROM 테이블 또는 객체
*/

SELECT SYSDATE FROM DUAL;
SELECT 3 FROM DUAL;
SELECT CURRENT_DATE FROM DUAL; 

SELECT 3 + 5 FROM DUAL;