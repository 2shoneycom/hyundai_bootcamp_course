-- 0210 연습문제

-- 1.도서 테이블에서 가격 순으로 내림차순 정렬하여,  도서명, 저자, 가격 출력 (가격이 같으면 저자 순으로 오름차순 정렬)
SELECT bookName, bookAuthor, bookPrice
FROM book
ORDER BY bookPrice DESC, bookAuthor;

-- 2.도서 테이블에서 저자에 '길동'이 들어가는 도서의 총 재고 수량 계산하여 출력
SELECT bookAuthor, bookStock
FROM book
WHERE bookAuthor LIKE '%길동%';

-- 3.도서 테이블에서 ‘서울 출판사' 도서 중 최고가와 최저가 출력
SELECT MIN(bookPrice) AS "서울 출판사 도서 최저가", MAX(bookPrice) AS "서울 출판사 도서 최고가"
FROM book
WHERE pubNo = 1;

-- 4.도서 테이블에서 출판사별로 총 재고수량과 평균 재고 수량 계산하여 출력 (‘총 재고 수량’으로 내림차순 정렬)
SELECT SUM(bookStock) AS "총 재고수량", AVG(bookStock) AS "평균 재고수량"
FROM book
GROUP BY pubNo
ORDER BY "총 재고수량" DESC;

-- 5.도서판매 테이블에서 고객별로 ‘총 주문 수량’과 ‘총 주문 건수’ 출력. 단 주문 건수가 2이상인 고객만 해당
SELECT clientNO, SUM(bsQty) AS "총 주문 수량", COUNT(*) AS "총 주문 건수"
FROM bookSale
GROUP BY clientNo
HAVING COUNT(*) >= 2;

-- 모든 도서에 대하여 도서의 도서번호, 도서명, 출판사명 출력
SELECT DISTINCT bookNo AS 도서번호, bookName AS 도서명, pubName AS 출판사명
FROM book B
    INNER JOIN publisher P ON B.pubNo = P.pubNo;

-- ‘서울 출판사'에서 출간한 도서의 도서명, 저자명, 출판사명 출력 (출판사명 사용)
SELECT bookName AS 도서명, bookAuthor AS 저자명, pubName AS 출판사명
FROM book B
    INNER JOIN publisher P ON B.pubNo = P.pubNo
WHERE p.pubName = '서울 출판사';

-- ＇정보출판사'에서 출간한 도서 중 판매된 도서의 도서명 출력 (중복된 경우 한 번만 출력) (출판사명 사용)
SELECT UNIQUE bookName AS 도서명
FROM book B
    INNER JOIN publisher P ON B.pubNo = P.pubNo
WHERE p.pubName = '정보출판사';

-- 도서가격이 30,000원 이상인 도서를 주문한 고객의 고객명, 도서명, 도서가격, 주문수량 출력
SELECT clientName AS 고객명, bookName AS 도서명, bookPrice AS 도서가격, bsQty AS 주문수량
FROM client C
    INNER JOIN bookSale BS ON C.clientNo = BS.clientNo
    INNER JOIN book B ON b.bookNo = BS.bookNo
WHERE B.bookPrice >= 30000;

-- '안드로이드 프로그래밍' 도서를 구매한 고객에 대하여 도서명, 고객명, 성별, 주소 출력 (고객명으로 오름차순 정렬)
SELECT bookName AS 도서명, clientName AS 고객명, clientGender AS 성별, clientAddress AS 주소
FROM client C
    INNER JOIN bookSale BS ON C.clientNo = BS.clientNo
    INNER JOIN book B ON b.bookNo = BS.bookNo
WHERE B.bookName = '안드로이드 프로그래밍'
ORDER BY C.clientName;

-- ‘도서출판 강남'에서 출간된 도서 중 판매된 도서에 대하여 ‘총 매출액’ 출력
SELECT SUM(bsQty*bookPrice) AS "총 매출액"
FROM bookSale BS
    INNER JOIN book B ON B.bookNo = BS.bookNo
    INNER JOIN publisher P ON p.pubNo = B.pubNo
WHERE P.pubName = '도서출판 강남';

-- ‘서울 출판사'에서 출간된 도서에 대하여 판매일, 출판사명, 도서명, 도서가격, 주문수량, 주문액 출력
SELECT bsDate AS "판매일", pubName AS "출판사명", bookName AS 도서명, bookPrice AS 도서가격, bsQty AS 주문수량, bsQty*bookPrice AS 주문액
FROM bookSale BS
    INNER JOIN book B ON B.bookNo = BS.bookNo
    INNER JOIN publisher P ON p.pubNo = B.pubNo
WHERE P.pubName = '서울 출판사';

-- 판매된 도서에 대하여 도서별로 도서번호, 도서명, 총 주문 수량 출력
SELECT B.bookNo AS 도서번호, B.bookName AS 도서명, SUM(BS.bsQty*B.bookPrice) AS "총 주문 수량"
FROM bookSale BS
    INNER JOIN book B ON B.bookNo = BS.bookNo
GROUP BY B.bookNo, B.bookName;

-- 판매된 도서에 대하여 고객별로 고객명, 총구매액 출력 ( 총구매액이 100,000원 이상인 경우만 해당)
SELECT C.clientName AS 고객명, SUM(bookPrice*bsQty) AS "총구매액"
FROM client C
    INNER JOIN bookSale BS ON BS.clientNo = C.clientNo
    INNER JOIN book B ON B.bookNo = BS.bookNo
GROUP BY C.clientName;

-- 판매된 도서 중 ＇도서출판 강남'에서 출간한 도서에 대하여 고객명, 주문일, 도서명, 주문수량, 출판사명 출력 (고객명으로 오름차순 정렬)
SELECT clientName AS 고객명, bsDate AS 주문일, bookName AS 도서명, bsQty AS 주문수량, pubName AS 출판사명
FROM bookSale BS
    INNER JOIN book B ON B.bookNo = BS.bookNo
    INNER JOIN client C ON C.clientNo = BS.clientNo
    INNER JOIN publisher P ON P.pubNo = B.pubNo
WHERE pubName = '도서출판 강남'
ORDER BY C.clientName;
