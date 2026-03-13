-- 오라클 내장함수 정리
-- 문자열 함수, DATE 함수, 데이터 정리 함수, 수학함수(ROUND)

-- ROUND 함수 : 반올림 값을 구하는 함수

/*
    ROUND(값, 자리수): 반 올림 기준 위치 자리수
    자리수 아래서 반올림하여 자리수까지 출력
    양수 값: 소수점 오른쪽 자릿수
    음수 값: 소수점 왼쪽 자릿수
*/

-- 고객별 평균 주문액을 검색
SELECT clientNo, 
    ROUND(AVG(bsQty * bookPrice)) "평균 주문액", -- 자릿수 생략(1자리까지 출력-기본설정값)
    ROUND(AVG(bsQty * bookPrice), 0) "1자리까지 출력",
    ROUND(AVG(bsQty * bookPrice), -1) "10자리까지 출력",
    ROUND(AVG(bsQty * bookPrice), -2) "100자리까지 출력",
    ROUND(AVG(bsQty * bookPrice), -3) "1000자리까지 출력"
FROM book, bookSale
WHERE book.bookNo = bookSale.bookNo
GROUP BY bookSale.clientNo;

/*
    문자함수
    REPLACE(): 문자열을 치환하는 함수
    LENGTH(): 글자의 수를 반환하는 함수
    LENGTHB(): 바이트 수 반환
    SUBSTR(): 지정한 길이만큼의 문자열을 반환하는 함수
*/

-- 서점에서 판매중인 도서 정보를 출력하시오. 단, 안드로이드 관련 제목에 한글 안드로이드인 도서는 영문 ANDROID로 변환해서 출력
-- REPLACE(): 문자열을 치환하는 함수
SELECT bookNo, REPLACE(bookName, '안드로이드', 'Android'), bookAuthor, bookPrice
FROM book;

SELECT bookNo, REPLACE(bookName, '안드로이드', 'Android'), bookAuthor, bookPrice
FROM book
WHERE bookName LIKE '%안드로이드%';

-- LENGTH(): 글자의 수를 반환하는 함수
-- LENGTHB(): 바이트 수 반환

-- 서울 출판사에서 출판한 도서의 도서명과 글자수, 바이트수, 출판사명 출력
SELECT bookName, LENGTH(bookName) 도서명길이, LENGTHB(bookName) AS 도서명크기, pubName
FROM book B, publisher P
WHERE B.pubNo = P.pubNo AND P.pubName = '서울 출판사';

-- SUBSTR(문자열, 시작 위치, 길이): 지정한 길이만큼의 문자열을 반환하는 함수
SELECT SUBSTR(bookAuthor, 1, 1) 성, SUBSTR(bookAuthor, 2, 2) 이름
FROM book;

-- 문자열 연결 : CONCAT() 함수, || 연결 연산자
SELECT CONCAT('문자열', '연결방법1') AS "문자열 연결방법1", '문자열'||' '||'연결방법2' AS "문자열 연결방법2"
FROM DUAL;

-- 여러 컬럼을 한 개의 컬럼으로 구성 (문자열 결합)
SELECT bookAuthor||' : '||bookName||' : '||bookPrice
FROM book;

-- LOWER()/UPPER()/INITCAP()
SELECT LOWER('Java programming'), UPPER('Java programming'), INITCAP('java programming')
FROM dual;

-- INSTR : 문자열에서 지정된 문자열 검색해서 위치 반환, 첫 번째 출현하는 위치를 반환
SELECT INSTR('초등학생, 고등학생, 대학생', '학생', 1) -- 반환값은 학생글자가 시작되는 위치
FROM DUAL;
SELECT INSTR('초등학생, 고등학생, 대학생,', '학생', 1, 2) -- 반환값은 두 번째 학생 글자가 시작되는 위치
FROM DUAL;

-- 문자열 처리할 때 주의할 사항 : 공백을 제대로 처리해야함
-- 문제열 처리시 앞뒤 공백은 제거 후 사용
-- TRIM() 문자열 공백 처리
SELECT TRIM(' 대한민국 ')
FROM dual;

-- 공백이 아닌 다른 문자 제거
SELECT TRIM(BOTH '*' FROM '****대한민국****')
FROM DUAL;
SELECT TRIM(LEADING '*' FROM '****대한민국****') -- 앞쪽 제거
FROM DUAL;
SELECT TRIM(TRAILING '*' FROM '****대한민국****') -- 뒤쪽 제거
FROM DUAL;

--------------------------------------------------------------------------------
-- 날짜 관련한 기능
-- 현재 날짜 출력: SYSDATE, CURRENT_DATE

SELECT SYSDATE FROM DUAL;
SELECT CURRENT_DATE FROM DUAL; -- 현재 일자

SELECT SYSDATE+1 FROM DUAL; -- 1일 후
SELECT SYSDATE-1 FROM DUAL; -- 1일 전

SELECT SYSDATE-1 어제, SYSDATE+1 내일, sYSDATE+2 모레 FROM DUAL;

SELECT SYSDATE+7 일주일후 FROM DUAL;

-- 경과 단위를 MONTH로 처리: ADD_MONTHS(날짜, 경과월)
SELECT ADD_MONTHS(SYSDATE, 1) -- 1달 후
FROM DUAL;

--------------------------------------------------------------------------------

-- 데이터 정리 함수
-- 순위 검색 함수
-- RANK()/DENSE RANK()/ROW_NUMBER()






CREATE TABLE CUBETBL(
    PRDNAME VARCHAR2(10),
    COLOR VARCHAR2(6),
    AMOUNT NUMBER(2)
    );
INSERT INTO CUBETBL VALUES('컴퓨터','검정',11);
INSERT INTO CUBETBL VALUES('컴퓨터','파랑',22);
INSERT INTO CUBETBL VALUES('모니터','검정',33);
INSERT INTO CUBETBL VALUES('모니터','파랑',44);
INSERT INTO CUBETBL VALUES('마우스','검정',55);
INSERT INTO CUBETBL VALUES('마우스','파랑',66);

SELECT * FROM CUBETBL;

SELECT prdName, color, SUM(amount) AS "금액합계"
FROM cubeTBL
GROUP BY CUBE(color, prdName)
ORDER BY prdName, color;





create table pivotTest(
  singer varchar2(10),
  season varchar2(10),
  amount number(3)
);
insert into pivotTest values('김범수','겨울',10);
insert into pivotTest values('윤종신','여름',15);
insert into pivotTest values('김범수','가을',25);
insert into pivotTest values('김범수','봄',3);
insert into pivotTest values('김범수','봄',37);
insert into pivotTest values('윤종신','가을',40);
insert into pivotTest values('김범수','여름',14);
insert into pivotTest values('김범수','겨울',22);
insert into pivotTest values('윤종신','여름',64);