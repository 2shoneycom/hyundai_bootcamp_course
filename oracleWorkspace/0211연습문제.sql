-- 0211 연습문제

-- 서브 쿼리 활용해서 질의 완성하세요 (JOIN 등 다른 기능도 사용해 볼 것)

-- 호날두(고객명)가 주문한 도서의 총 구매량 출력
SELECT COUNT(*) AS "총 구매량"
FROM bookSale BS
WHERE BS.clientNo = (SELECT clientNo
                    FROM client C
                    WHERE C.clientName = '호날두');

-- ‘정보출판사’에서 출간한 도서를 구매한 적이 있는 고객명 출력
SELECT clientName AS 고객명
FROM client C
WHERE EXISTS (SELECT *
                FROM bookSale BS
                INNER JOIN book B ON BS.bookNo = B.bookNo
                INNER JOIN publisher P ON P.pubNo = B.pubNo
                WHERE P.pubName = '정보출판사' AND BS.clientNo = C.clientNo);

-- 베컴이 주문한 도서의 최고 주문수량 보다 더 많은 도서를 구매한 고객명 출력
SELECT clientName
FROM client C
JOIN bookSale BS ON C.clientNo = BS.clientNo
WHERE BS.bsQty > (SELECT MAX(bsQty)
                    FROM bookSale
                    WHERE clientNo = (SELECT clientNo FROM client WHERE clientName = '베컴'));

-- 천안에 거주하는 고객에게 판매한 도서의 총 판매량 출력
SELECT SUM(bsQty)
FROM bookSale BS
WHERE BS.clientNo IN (SELECT C.clientNo
                    FROM client C
                    WHERE C.clientAddress = '천안');
                    
                    
-- 함수 사용 연습 문제
CREATE TABLE sales (
prdName VARCHAR2(20),
salesDate VARCHAR2(10),
prdCompany VARCHAR2(10),
salesAMount NUMBER(8));

INSERT INTO sales VALUES ('노트북', '2021.01', '삼성', 10000);
INSERT INTO sales VALUES ('노트북', '2021.03', '삼성', 20000);
INSERT INTO sales VALUES ('냉장고', '2021.01', 'LG', 12000);
INSERT INTO sales VALUES ('냉장고', '2021.03', 'LG', 20000);
INSERT INTO sales VALUES ('프린터', '2021.01', 'HP', 3000);
INSERT INTO sales VALUES ('프린터', '2021.03', 'HP', 1000);

-- 저자 중 성(姓)이 '손'인 모든 저자 출력

-- 저자 중에서 같은 성(姓)을 가진 사람이 몇 명이나 되는지 알아보기 위해 성(姓)별로 그룹 지어 인원수 출력

-- 아래와같은 테이블을 생성하고 CUBE, ROLLUP, GROUPING SETS를 적용시켜 결과를 설명하시오
-- 자세한 결과 설명 필요

-- 주문 테이블에서 주문일에 7일을 더한 날을 배송일로 계산하여 출력

-- 도서 테이블에서 도서명과 출판연도 출력
