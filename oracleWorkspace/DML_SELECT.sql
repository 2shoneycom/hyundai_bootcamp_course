/*
    SELECT 연습
*/

-- 연습용 테이블에 제약조건 추가
-- 기본키 제약조건 추가
ALTER TABLE publisher ADD PRIMARY KEY (pubNo);
ALTER TABLE book ADD PRIMARY KEY (bookNo);
ALTER TABLE client ADD PRIMARY KEY (clientNo);
ALTER TABLE bookSale ADD PRIMARY KEY (bsNo);

describe publisher;

ALTER TABLE book
  ADD CONSTRAINT FK_book_publisher  
  FOREIGN KEY (pubNo) REFERENCES publisher(pubNo);
ALTER TABLE booksale
  ADD CONSTRAINT FK_booksale_client  
  FOREIGN KEY (clientNo) REFERENCES client (clientNo);
ALTER TABLE booksale
  ADD CONSTRAINT FK_booksale_book  
  FOREIGN KEY (bookNo) REFERENCES book (bookNo);

------------------------------------------------------------------------------------------
/*
    SELECT 문 : 테이블에서 조건에 맞는 행 검색
    
    - 기본 형식 -
    SELECT [ALL|DISTINCT] 열이름 리스트|함수식
    FROM 테이블명
    [WHERE 조건]
    [GROUP BY 열이름]
    [HAVING 조건]
    [ORDER BY 열이름 [ASC|DEC]
*/
------------------------------------------------------------------------------------------

-- 도서 테이블에서 모든(*) 레코드 검색
SELECT * FROM book;

-- 모든 레코드의 도서명과 가격 컬럼을 검색
SELECT bookName, bookPrice FROM book;

-- DISTINCT
-- 속성값이 중복되어 있으면 한번만 출력
-- 현재 시점에 진열된 책들의 출판사 번호 중복값 없이 확인
SELECT DISTINCT pubNo FROM book;
SELECT pubNo FROM book;

-- 현재 서점에 진열된 도서들의 저자를 확인
SELECT bookAuthor FROM book;
SELECT DISTINCT bookAuthor FROM book;

-- 한 번이라도 주문한 적이 있는 고객 리스트 확인

------------------------------------------------------------------------------------------
-- WHERE 조건절
-- 조건에 맞는 레코드만 검색
/*
    사용 연산
    비교 (=, <, >, <=, >=, !=)
    범위 (BETWEEN)
    리스트에 포함 (IN, NOT IN)
    NULL (IS NULL, IS NOT NULL)
    논리 (AND, OR)
    패턴 매칭 (LIKE)
*/

-- 비교 (=, <, >, <=, >=, !=)

-- 저자가 '홍길동'인 도서의 도서명, 저자 검색
DESCRIBE book;

SELECT bookName, bookAuthor
FROM book
WHERE bookAuthor = '홍길동'; 

-- 가격이 30000 이상인 레코드의 도서명, 가격, 재고 검색
SELECT bookName, bookPrice, bookStock
FROM book
WHERE bookPrice >= 30000;

-- 도서 재고가 3~5사이인 도서의 도서명, 재고 검색
SELECT bookName, bookStock
FROM book
WHERE bookStock >= 3 AND bookStock <= 5;

-- 범위 연산자(BETWEEN 범위의 시작값 AND 범위의 끝값) : 이상과 이하
-- 시작값 >= AND <= 끝값
SELECT bookName, bookStock
FROM book
WHERE bookStock BETWEEN 3 AND 5;

-- 리스트 포함 여부 (IN)
-- 리스트 포함되지 않는지의 여부 (NOT IN)
-- 출판사번호가 1이기너 2인 도서의 도서명 출판사 번호 검색
SELECT bookName, pubNo
FROM book
WHERE pubNo = '1' OR pubNo = '2';

-- IN 연산자 사용
SELECT bookName, pubNo
FROM book
WHERE pubNo In('1', '2');

-- 출판사 번호가 2가 아닌 다른 출판사에서 출판한 도서의 도서명, 출판사 번호 검색
SELECT bookName, pubNo
FROM book
WHERE pubNo != '2';

-- NOT IN 사용
SELECT bookName, pubNo
FROM book
WHERE pubNo NOT IN ('2');

-- 도서 테이블에서 출판사 번호가 1 또는 2가 아닌 레코드의 도서명/출판사번호 검색
SELECT bookName, pubNo
FROM book
WHERE pubNo NOT IN('1', '2');

-- NULL 과 관련된 연산
SELECT clientName, clientHobby FROM client;

-- 고객 데이터중 취미 정보가 입력되어있는 고객의 이름과 취미 레코드를 검색
SELECT clientName, clientHobby
FROM client
WHERE clientHobby IS NOT NULL;

-- 아자르 클라이언트 취미는 빈값이 입력되어 있음
SELECT clientName, clientHobby
FROM client
WHERE clientHobby = ' ';

-- 고객 데이터중 취미정보가 입력되지 않은 고객의 이름과 취미 레코드를 검색
SELECT clientName, clientHobby
FROM client
WHERE clientHobby IS NULL;

-- 논리(AND, OR)
-- 두개 이상의 컬럼 조건과 매칭시킬때

-- 도서 중 저자가 '홍길동' 이면서 재고가 3권 이상인 도서의 모든 정보 검색
SELECT *
FROM book
WHERE bookAuthor = '홍길동' AND bookStock >= 3;

-- 도서 중 저자가 '홍길동'이거나 재고가 3권 이상인 도시의 모든 정보 검색
SELECT *
FROM book
WHERE bookAuthor = '홍길동' OR bookStock >= 3;

/*
    문자열 값 인 경우 LIKE 연산 이용 패턴 매칭
    와일드카드 문자
        % : 0개 이상의 문자를 가진 문자열
        _ : 단일 문자
        Ex. '홍길동%' : 홍길동, 홍길동이, 홍길동부모님
            -> 홍길동으로 시작하는 모든 문자열
            '%홍길동%': 홍길동, 홍길동이, 홍길동부모님, 친구 홍길동, 형홍길동이가
            -> '홍길동'을 포함하고 있는 모든 문자열
            '%홍길동' : 홍길동, 친구홍길동, 형홍길동
            -> '홍길동'으로 끝나는 모든 문자열
            
            '____': 4개의 문자로 구성된 문자열(홍길동이, 형홍길동, 버스타기)
*/

-- 출판사가 포함된 모든 출판사 이름
SELECT pubName
FROM publisher
WHERE pubName LIKE '%출판사%';

-- '출판사'로 끝나는 출판사 이름
SELECT pubName
FROM publisher
WHERE pubName LIKE '%출판사';

-- 고객 테이블에서 출생년도가 1990년대인 고객의 모든 컬럼을 검색
SELECT *
FROM client
WHERE clientBirth LIKE '199%';

-- 고객 이름이 4글자인 고객의 이름과 고객번호를 검색
SELECT clientName, clientNo
FROM client
WHERE clientName LIKE '____';

-- NOT 연산 (부정 연산)
-- NOT LIKE (패턴) : 패턴과 부합하지 않는 레코드
-- 도서명에 안드로이드가 포함되지 않는 도서의 도서명, 가격 검색
SELECT bookName, bookPrice
FROM book
WHERE bookName NOT LIKE ('%안드로이드%');

-- 도서명에 안드로이드가 포함되는 도서의 도서명, 가격 검색
SELECT bookName, bookPrice
FROM book
WHERE bookName LIKE ('%안드로이드%');

---------------------------------------------------------------------------
-- ORDER BY : SQL 질의어 마지막에 표현
-- 특정 컬럼의 값을 기준으로 질의 결과(SELECT까지 종료된 결과) 정렬
-- ASC : 오름차순(생략 가능) / DESC : 내림 차순
-- ORDER BY 컬럼명1 ASC/DESC[, 컬럼명2 ASC/DESC]

SELECT * FROM book
ORDER BY bookName ASC;
-- bookName을 기준으로 레코드의 모든 컬럼 이동하게 됨
-- 정렬 기준 : 0~9 A~Z 가~하

-- ASC는 생략 가능
SELECT * FROM book
ORDER BY bookName;

-- 내림차순: DESC 반드시 포함
SELECT * FROM book
ORDER BY bookName DESC;

-- 재고 수량을 기준으로 내림차순 정렬하여 검색
-- select 되지 않는 컬럼도 정렬 조건으로 사용 가능
SELECT bookName, bookAuthor
FROM book
ORDER BY bookStock DESC;

SELECT bookNAme, bookAuthor, bookStock
FROM book
ORDER BY bookStock DESC;

-- 재고수량이 5권 이상인 도서의 도서명, 저자, 재고수량 확인하는데 재고슈량 기준으로 내림차순 정렬
SELECT bookName, bookAuthor, bookStock
FROM book
WHERE bookStock >= 5
ORDER BY bookStock DESC;

-- 도서테이블에서 저자를 기준으로 내림차순 정렬하시오 (도서명, 저자 검색)
SELECT bookName, bookAuthor
FROM book
ORDER BY bookAuthor DESC;

-- 도서테이브렝서 저자를 기준으로 내림차순 정렬하시오. 저자가 동일한 경우 BOOKNO 기준 오름차순 정렬
SELECT bookNo, bookName, bookAuthor
FROM book
ORDER BY bookAuthor DESC, bookNo ASC;

SELECT bookNo, bookName, bookAuthor
FROM book
ORDER BY bookAuthor DESC, bookNO DESC;

-- SELECT 되는 컬럼의 표현명 변경
-- SELECT AS 별명
-- SELECT 절에 표현된 컬럼명이 반환되는 객체(테이블)의 컬럼명으로 처리됨
SELECT 3+5, bookNo, bookName, bookAuthor
FROM book
ORDER BY bookAuthor DESC, bookNo ASC;

-- 상수 연산 컬럼은 테이블에 없는 컬럼이지만 SELECT 되어서 반환되는 테이블에는 컬럼을 생성하고 연산결과를 모든 레코드에 동일하게 뿌림
SELECT 3+5 AS CUST_NO, bookNo, bookName, bookAuthor
FROM book
ORDER BY bookAuthor DESC, bookNo ASC;

-- 도서가격 인상을 준비하고 있고 전체 도시에 대해서 10%인상된 가격 확인을 위한 검색 (도서 번호, 도서명, 도서가격10%인상된)
-- select 된 컬럼 값에 연산 추가 가능
SELECT bookNo, bookName, bookPrice, bookPrice * 1.1
FROM book;

-- 연산 진행한 select된 컬럼명은 연산식이 그대로 표현됨
-- 칼럼명 변경 표현하도록 권장
-- 별명에 띄어쓰기가 없으면 "" 없어도 됨
SELECT bookNo AS 도서번호, bookName AS 도서명, bookPrice AS 도서가격, bookPrice * 1.1 AS 인상가격
FROM book;

-- 도서판매 테이블에서 최대/최소 판매수량을 검색
SELECT MAX(bsQty), MIN(bsQty)
FROM bookSale;