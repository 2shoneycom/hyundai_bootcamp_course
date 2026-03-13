/*
데이터 조작어(DML): 데이터 입력/수정/삭제/검색
INSERT/UPDATAE/DELETE/SELECT
*/

-- INSERT
-- 기본형식: INSERT INTO 테이블명(컬럼명 리스트) VALUES (값리스트);

-- 수업용 테이블
DROP TABLE PUB;

CREATE TABLE pub (
    pubNo VARCHAR2(10) NOT NULL PRIMARY KEY,
    pubName VARCHAR2(30) NOT NULL
);

INSERT INTO pub(pubNo, pubName) VALUES('1', '서울 출판사');
INSERT INTO pub(pubNo, pubName) VALUES('2', '강남 출판사');
INSERT INTO pub(pubNo, pubName) VALUES('3', '종로 출판사');

SELECT * FROM pub;

-- BOOK 테이블 외래키 추가
ALTER TABLE book ADD CONSTRAINTS FK_book_pub FOREIGN KEY(pubNo) REFERENCES pub(pubNo);

SELECT * FROM BOOK;

-- BOOK 테이블에 데이터 입력
INSERT INTO book(bookNo, bookNAme, bookPrice, bookDate, pubNo)
    VALUES('5', '자바스크립트', 23000, '2019-05-17', '1');
SELECT * FROM BOOK;

-- 모든 컬럼 값 입력할 경우 열 이름 생략 가능 : 컬럼값이 1개라도 부족하면 오류
-- 컬럼값의 순서는 생성할 때 순서를 지켜줌
INSERT INTO book
    VALUES('6', 'C++프로그래밍', 25000, '2024-02-02', '2');
SELECT * FROM BOOK;

-- 여러개의 레코드를 한 번에 INSERT
-- DBMS마다 차이가 있음
/*
    INSERT ALL
        INTO 테이블명 ([컬럼명나열]) VALUES (값 나열)
        INTO 테이블명 ([컬럼명나열]) VALUES (값 나열)
        INTO 테이블명 ([컬럼명나열]) VALUES (값 나열)
    SELECT *
    FROM DUAL; -- DUAL : 가짜(가상)테이블
*/

INSERT ALL
    INTO book VALUES ('7', '알고리즘', 25000, '2023-02-02', '1')
    INTO book VALUES ('8', '웹 프로그래밍', 26000, '2025-11-11', '2')
SELECT *
FROM DUAL; 

-- 일부 컬럼값만 삽입하려면 컬럼명은 추가되어야 함
INSERT INTO book (bookNo, bookNAme, bookDate, pubNo)
    VALUES ('9', 'C프로', '2024-02-02', '2');
SELECT * FROM BOOK;








