-- 종합연습문제
-- 이승헌

-- 다음과 같이 SQL 문 작성(모든 테이블 속성 데이터내용으로 구성 크기는 적절하게)
-- 1.고객 테이블 (customer) 생성
CREATE TABLE customer (
    custNo NUMBER(8) NOT NULL PRIMARY KEY,
    custName VARCHAR2(20) NOT NULL,
    custPhone VARCHAR2(20),
    custAddress VARCHAR(30)
);

-- 2.주문 테이블 (orderProduct) 생성 (이미 생성된 상품(product) 테이블에 대한 주문)
CREATE TABLE orderProduct (
    orderNo NUMBER(8) NOT NULL PRIMARY KEY,
    orderDate DATE NOT NULL,
    orderQTY NUMBER(8) NOT NULL,
    custNo NUMBER(8) NOT NULL,
    prdNo NUMBER(8) NOT NULL,
    CONSTRAINT FK_customer_custNo FOREIGN KEY(custNo) REFERENCES customer(custNo),
    CONSTRAINT FK_customer_prdNo FOREIGN KEY(prdNo) REFERENCES prd(prdNo)
);

-- prd/orderProduct와　customer 테이블에 적절한 관계 설정
-- 고객 테이블의 전화번호 열을 NOT NULL로 변경
-- 고객 테이블에 ‘성별’, ‘나이’ 열 추가
-- 고객, 주문 테이블에 데이터 삽입 (3개씩)
-- 주문 테이블에서 상품번호가 2인 행의 주문수량을 3으로 수정