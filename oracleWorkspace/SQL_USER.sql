-- 방법 1: CONSTRAINT PK_product_prdNo PRIMARY KEY(prdNo)
CREATE TABLE product (
    prdNo VARCHAR2(10) NOT NULL,
    prdName VARCHAR2(30) NOT NULL,
    prdPrice NUMBER(8),
    prdCompany VARCHAR2(30),
    CONSTRAINT PK_product_prdNo PRIMARY KEY(prdNo)
    ); -- 모든 쿼리는 ;으로 종료해야 함

-- 방법 2: 속성 옆에 PRIMARY KEY 지정
CREATE TABLE product1 (
    prdNo VARCHAR2(10) NOT NULL PRIMARY KEY,
    prdName VARCHAR2(30) NOT NULL,
    prdPrice NUMBER(8),
    prdCompany VARCHAR2(30)
    );

-- 방법 3: 구성 마지막에 PRIMARY KEY(prdNO)만 추가
CREATE TABLE product2 (
    prdNo VARCHAR2(10) NOT NULL,
    prdName VARCHAR2(30) NOT NULL,
    prdPrice NUMBER(8),
    prdCompany VARCHAR2(30),
    PRIMARY KEY(prdNo)
    );

-- 방법 4(권장하지 않음)
CREATE TABLE product3 (
    prdNo VARCHAR2(10) NOT NULL CONSTRAINT PK_product_prdNo4 PRIMARY KEY,
    prdName VARCHAR2(30) NOT NULL,
    prdPrice NUMBER(8),
    prdCompany VARCHAR2(30)
    );


/*
    출판사 테이블 생성(출판사번호, 출판사명)
    제약조건
        -기본키 prdNo, NOT NULL
        -pordName NOT NULL
*/
CREATE TABlE publisher(
    prdNo VARCHAR2(10) NOT NULL PRIMARY KEY,
    prdName VARCHAR2(30) NOT NULL
);

/*
    도서 테이블 (book)
    한개의 도서는 출판사에서 발행
    서점은 거래하는 출판사가 존재함
    기본키 : 도서번호(bookNo)
    외래키 : 출판사테이블의 출판사번호(pubNo)
*/

-- 외래키(참조무결성) 제약조건 추가
CREATE TABLE book(
    bookNo VARCHAR2(10) NOT NULL PRIMARY KEY,
    bookName VARCHAR2(30) NOT NULL,
    bookPrice NUMBER(8) DEFAULT 10000 CHECK(bookPrice > 1000),
    bookDate DATE,
    pubNo VARCHAR2(10) NOT NULL,
    CONSTRAINT FK_book_publisher FOREIGN KEY(pubNo) REFERENCES publisher(prdNo)
);

-- 열(속성)추가: ADD
ALTER TABLE product ADD (prdUnitPrice NUMBER(8), prdStock NUMBER(12));

-- 열(속성) 데이터 형식 변경
ALTER TABLE product MODIFY prdUnitPrice NUMBER(4);

-- 열(속성) 제약조건 변경 (prdName NOT NULL -> NULL)
ALTER TABLE product MODIFY prdName VARCHAR2(30) NULL;

-- 컬럼명 변경 : RENAME COLUMN 기존컬럼명 TO 새 컬럼명
ALTER TABLE product RENAME COLUMN prdUnitPrice TO prdUprice;

-- 컬럼 삭제 
ALTER TABLE product DROP COLUMN prdStock;

-- 컬럼 여러개 삭제: DROP(컬럼명1, 컬럼명2, ...)
ALTER TABLE product DROP (prdUprice, prdCompany);

-- 제약조건 삭제
ALTER TABLE product DROP PRIMARY KEY;

-- 참조무결성 (외래키 제약조건)으로 참조되어 있는 경우에는 기본키 제약조건 삭제 불가
-- publisher 는 book이 참조하고 있음
ALTER TABLE publisher DROP PRIMARY KEY;

-- 참조하고 있어도 무조건 기본키 삭제: CASCADE (권장하지 않음)
ALTER TABLE publisher DROP PRIMARY KEY CASCADE;

-- 제약조건 추가 : 기본키 추가
ALTER TABLE publisher ADD CONSTRAINT PK_publisher_prdNo PRIMARY KEY(pubNo);

-- 외래키 추가
ALTER TABLE book ADD CONSTRAINT FK_book_publisher FOREIGN KEY(pubNo) REFERENCES publisher(pubNo);

/*
    테이블 삭제 : 테이블의 모든 구조와 모든 데이터 삭제
    데이터만 삭제 : DML 문의 DELETE 문
    삭제 쿼리 : DROP TABLE 테이블명 [PURGE | CASCADE CONSTRAINTS]
    PURGE : 복구 가능한 임시 테이블 생성하지 않고 영구히 삭제
    CASCADE CONSTRAINTS : 테이블이 다른 테이블에 의해 참조되고 있어도 강제 삭제, 권장하지 않음
*/

DROP TABLE publisher;


--------------------------------------------------------------------------------
/*
시퀀스
    데이터베이스 객체로 유일한 값으로 일련번호 생성
    지정된 수치로 증가하거나 감소
    기본키 값을 일련번호로 자동 생성할 때 사용
    최대 15개까지 생성 가능
    테이블과 독립적으로 저장되고 생성
    하나의 시퀀스를 여러 테이블에서 사용 가능
*/

/*
CREATE SEQUENCE 시퀀스식별자
    START WITH 시작숫자
    INCREMENT BY 증가감값
    MAXVALUE 최댓값
    MINVALUE 최솟값
    CYCLE/NOCYCLE -> 최대값 또는 최소값에 도달했을때 다시 시작할건지
*/

CREATE SEQUENCE NO_SEQ
    START WITH 1
    INCREMENT BY 1
    MAXVALUE 10000
    MINVALUE 1
    NOCYCLE;

-- 현재 시퀀스 값 검색 : 현재까지 사용한 시퀀스 값 반환
SELECT NO_SEQ.CURRVAL
FROM dual;

-- 시퀀스 수정
ALTER SEQUENCE NO_SEQ
    MAXVALUE 1000;

-- 시퀀스 구조 속성 검색 
-- USER_SEQUENCES : SYSTEM TABLE 활용
SELECT * FROM USER_SEQUENCES;

-- 시퀀스 삭제
DROP SEQUENCE NO_SEQ;

CREATE TABLE board(
    bNo NUMBER PRIMARY KEY,
    bSubject VARCHAR2(30) NOT NULL,
    bName VARCHAR(20) NOT NULL,
    bContent VARCHAR2(100)
);


INSERT INTO board VALUES(NO_SEQ.NEXTVAL, '추석', '홍길동', '...');
INSERT INTO board VALUES(NO_SEQ.NEXTVAL, '추석', '홍길동', '...');
SELECT * FROM board;

-----------
-- 불필요한 테이블 삭제 후 IMPORT
DROP TABLE book;
DROP TABLE publisher;


-- 기본키 제약조건 추가
ALTER TABLE prd
    ADD CONSTRAINT pk_prd_prdNo
    PRIMARY KEY (prdNo);
