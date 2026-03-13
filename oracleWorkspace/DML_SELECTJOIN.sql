-- 테이블의 결합: JOIN, SELECT의 확장: SUBQUERY

/*
    조인: 테이블의 결합
    관계형 데이터베이스의 특징
        1. 중복되는 데이터를 최소화
        2. 현재 테이블에 없는 데이터는 다른 테이블과의 관계를 통해 확인
        ex) 도서번호 1001번 도서를 출판한 출판사의 출판사명 검색
    
    JOIN의 종류
        1. INNER JOIN (가장 많이 사용) 
            - 공통되는 컬럼이 있을 때
            - 공통 속성의 값이 동일한 레코드만 반환
            - 두 테이블이 외래키와 기본키로 연결되어 있으면 공통 컬럼 : 외래키, 기본키
        2. OUTER JOIN
            - 공통되는 칼럼이 없을 때도 사용가능
            - 공통된 속성을 매개로하는 정보가 없더라도 버리지 않고 연산의 결과를 릴레이션에 표시
*/

SELECT * FROM book;
SELECT * FROM publisher;

SELECT * 
FROM book, publisher
WHERE book.pubNo = publisher.pubNo -- JOIN 조건
    AND bookNo = 1001;
    
SELECT bookNo, book.pubNo, pubName
FROM book, publisher
WHERE book.pubNo = publisher.pubNo -- JOIN 조건
    AND bookNo = 1001;

----------------------------------------------------------------------
-- INNER JOIN
/*
    SELECT 열 리스트
    FROM 테이블명 1
        INNER JOIN 테이블명 2
        ON 조인조건 (기본키=외래키)
*/

-- BOOKSALE 테이블과 CLIENT 테이블의 INNER JOIN
-- 주문테이블에서 확인가능한 고객의 정보: 주문한 적이 있는 고객의 주문정보와 고객정보
SELECT *
FROM bookSale
    INNER JOIN client
    ON bookSale.clientNo = client.clientNo;

-- 주문한 고객의 이름과 주소: 여러번 주문한 고객은 주문 수 만큼 레코드가 생성됨
SELECT client.clientNo, clientName, clientAddress
FROM client
    INNER JOIN bookSale
    ON client.clientNo = bookSale.clientNo;
    
SELECT client.clientNo, clientName, clientAddress
FROM client, bookSale
WHERE client.clientNo = bookSale.clientNo;
    
-- 주문한 적이 있는 고객 조회
SELECT DISTINCT client.clientNo, clientName, clientAddress
FROM client
    INNER JOIN bookSale
    ON client.clientNo = bookSale.clientNo;

-- 양쪽 테이블에 공통되는 열에 대해서는 테이블명 표기해서 모호성을 없애야 함
-- 테이블명 없으면 오류
-- ORA--00918: 열의 정의가 애매합니다 clientNo가 두 테이블 모두에 컬럼명으로 있음
SELECT DISTINCT clientNo, clientName, clientAddress
FROM client
    INNER JOIN bookSale
    ON clientNo = bookSale.clientNo;

-- 공통되는 컬럼에만 테이블명을 추가했음, 테이블명이 없는 컬럼은 검색시 효율이 떨어짐
SELECT DISTINCT client.clientNo, clientName, clientAddress
FROM client
    INNER JOIN bookSale
    ON client.clientNo = bookSale.clientNo;

-- 테이블에 별명 추가 FROM절과 JOIN절에서 --> 가장 많이 사용하는 방식
SELECT DISTINCT C.clientNo, C.clientName, C.clientAddress
FROM client C
    INNER JOIN bookSale B
    ON C.clientNo = B.clientNo;

-- JOIN으로만 명시 가능
SELECT DISTINCT C.clientNo, C.clientName, C.clientAddress
FROM client C
    JOIN bookSale B
    ON C.clientNo = B.clientNo;
    
-- DISTINCT 대신에 UNIQUE 사용 가능
SELECT UNIQUE C.clientNo, C.clientName, C.clientAddress
FROM client C
    INNER JOIN bookSale B
    ON C.clientNo = B.clientNo;

-- bookSale 테이블: 한 명의 고객은 여러권의 책을 주문할 수 있다 / 한 권의 책은 여러 고객에게 주문될 수 있다
-- 고객 - n -> 주문 <- n - 책
-- 기본키: bsNo
-- 외래키: clientNo, bookNo

-- 메시가 주문한 책의 도서명과 주문수량, 고객명을 검색
-- 도서 주문 테이블만으로 위 질의를 진행하려면 고객명과 도서명은 검색 불가능 함
-- 외래키인 clientNo, bookNo
SELECT clientNo, bookNo
FROM bookSale
WHERE clientNo = '1';

--3개 테이블에 대한 조인
SELECT clientName, bookName
FROM bookSale BS
    INNER JOIN client C ON C.clientNo = BS.clientNo
    INNER JOIN book B ON B.bookNo = BS.bookNo
WHERE clientNo = '1';

-- 메시가 주문한 도서의 도서명, 주문 수량, 고객명 검색
SELECT C.clientName, B.bookName, BS.bsQty
FROM bookSale BS
    INNER JOIN client C ON C.clientNo = BS.clientNo
    INNER JOIN book B ON B.bookNo = BS.bookNo
WHERE clientName = '메시';

-- 도서를 주문한 고객명, 주문정보, 도서명 검색
SELECT C.clientName, C.clientAddress, B.bookName, BS.bsNo, BS.bsDate, BS.bsQty
FROM bookSale BS
    INNER JOIN client C ON C.clientNo = BS.clientNo
    INNER JOIN book B ON B.bookNo = BS.bookNo
ORDER BY BS.bsNo; -- 정렬 기준 컬럼은 select 절에 없어도 사용 가능

-- 고객별로 총 주문수량 계산하여 고객명과 총 주문 수량 검색 주문수량 기준 내림차순 정렬 후 반환
SELECT C.clientNo, C.clientName, SUM(bsQty) AS "총 주문 수량"
FROM bookSale BS
    INNER JOIN client C ON C.clientNo = BS.clientNo
GROUP BY C.clientNo, C.clientName -- 그룹내에 또 다른 그룹을 구성하라는 조건
ORDER By "총 주문 수량" DESC;

-- WHERE 절 추가
-- 2019년부터 ~ 현재까지 판매된 도서의 주문일 고객명, 도서명, 도서 가격, 주문 수량, 주문액 계산하여 출력
-- 주문, 고객, 도서
SELECT BS.bsDate AS 주문일, C.clientName AS 고객명, B.bookName AS 도서명, BS.bsQty AS 주문수량, BS.bsQty*B.bookPrice AS 주문액
FROM bookSale BS
    INNER JOIN client C ON C.clientNo = BS.clientNo
    INNER JOIN book B ON B.bookNo = BS.bookNo
WHERE BS.bsDate >= '2019-01-01'
ORDER BY BS.bsDate DESC;

---------------------------------------------------------------------------------
/*
    외부조인 (Outer JOIN)
    공통 속성을 매개로 하는 정보가 없더라도 버리지 않고 표시
    값이 없는 대응 속성은 NULL 값을 채워서 반환
*/

-- 모든 고객은 0번 이상 주문을 할 수 있다
-- 한 번도 주문하지 않은 고객도 존재함
-- INNER JOIN은 주문한 고객정보만 결합
-- OUTER JOIN은 주문하지 않은 고객 정보까지 표현
SELECT *
FROM client C
    LEFT OUTER JOIN bookSale BS ON C.clientNo = BS.clientNo -- LEFT OUTER JOIN: client ^ bookSale 중 왼쪽을 기준으로 JOIN
ORDER BY C.clientNo;

-- RIGHT OUTER JOIN : 기준 테이블 bookSale
SELECT *
FROM client C
    RIGHT OUTER JOIN bookSale BS ON C.clientNo = BS.clientNo
ORDER BY C.clientNo;

-- OUTER JOIN 방법 - 조건절에서 (+) 기호로 표현
-- 확장되어야 할 테이블에 (+) 기호를 표현
SELECT *
FROM client C, bookSale BS
WHERE C.clientNo = BS.clientNo (+);

SELECT *
FROM client C, bookSale BS
WHERE C.clientNo (+) = BS.clientNo;

-- 서브 쿼리는 독립적 객체 반환이므로 조인연산 진행가능 GROUP BY 등 모든 연산 진행 가능

--------------------------------------------------------------------------------
-- 다중행 서브쿼리에서 사용가능
-- EXISTS: 서브쿼리의 결과가 행을 반환하면 참이되는 연산자
-- 메인쿼리와 서브쿼리의 매칭 조건 검사를 서브쿼리에서 진행함

-- WHERE 조건에서 사용 시 조건에 기준이 되는 컬럼이 쿼리 WHERE절에 표현되지 않는다
-- SUBQUERY에 표현됨

-- 메인쿼리의 테이블과 SUB쿼리의 테이블의 모든 레코드를 순회
-- IN 연산자를 사용한느 것과 유사함
-- IN : 서브쿼리에서 검색한 결과로 메인쿼리에서 다시 조건 검색을 진행
-- EXISTS: 두 테이블을 비교 검사 함

-- 도서를 구매한 적이 있는 고객
-- BOOKSALE 테이블에서 CLIENTNO 검색 후 반환되는 값을 활용해서 CLIENT 테이블 검색 (IN)
-- 1. BOOKSALE에서 조건에 해당되는 행이 존재하면 WHERE가 참이 됨
-- 2. 참이되는 레코드들에서 SELECT 진행
-- IN을 사용했을 때와 동일한 결과
    SELECT clientNo, clientName
    FROM client
    WHERE EXISTS (SELECT clientNo
                    FROM bookSale
                    WHERE client.clientNo = bookSale.clientNo);
                    -- 메인/서브쿼리의 두 테이블을 접근해서 메인테이블(client)의 clientNo가 서브테이블(bookSale)의 클라이언트 no에 포함되는지 확인
-- 도서를 구매한 적이 없는 고객
-- NOT IN을 사용했을 때와 동일한 결과
    SELECT clientNo, clinetName
    FROM client
    WHERE NOT EXISTS (SELECT clientNo
                    FROM bookSale
                    WHERE client.clientNo = bookSale.clientNo);

-- IN과 EXISTS의 차이: 데이터가 NULL인 경우

-- clientHobby에 NULL이 3개 포함되어 있음
SELECT clientHobby FROM client;

-- EXISTS:
SELECT clientNo
FROM client
WHERE EXISTS (SELECT clientHobby
                FROM client); -- 조건절 없으므로 client의 모든 레코드에 true가 반환이 됨

-- ANY:
-- 2번 고객이 주문한 도서의 최소 주문수량보다 더 많이 주문한 고객의 고객번호, 주문번호, 주문수량 검색
-- 1. 서브쿼리: 2번 고객이 주문한 모든 주문수량을 검색
-- 2. 메인쿼리: 검색된 모든 값보다 더 큰 주문값을 갖는 레코드 검색

SELECT bsQty FROM bookSale WHERE clientNo='2';

    SELECT clientNo, bsNo, bsQty
    FROM bookSale
    WHERE bsQty > ANY (SELECT bsQty FROM bookSale WHERE clientNo='2');
    -- 서브쿼리에서 검색된 값의 리스트가 (5, 2, 2)이므로 메인쿼리의 레코드는 bsQty가 2보다 크거나 5보다 크면 treu
    -- 반환된 서브쿼리 결과값에서 min인 값보다 큰 레코드를 선택
    -- 2번 고객이 주문한 주문번호 3번도 포함(2번 고객 주문과 고나련된 내용을 제외하고자 하면 2번 고객 제외 쿼리를 넣어야 함)
    SELECT clientNo, bsNo, bsQty
    FROM bookSale
    WHERE bsQTy > ANY (SELECT bsQty FROM bookSale WEHRE clientNo='2')
        AND clientNo != '2';

-- 모든 서브쿼리의 조건은 서브쿼리에서 종료 메인 쿼리에는 영향을 미치지 않음


