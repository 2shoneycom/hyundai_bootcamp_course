CREATE TABLE department (
    depCode VARCHAR2(10) NOT NULL,
    depName VARCHAR2(30) NOT NULL,
    depCell NUMBER(20),
    CONSTRAINT PK_department_depCode PRIMARY KEY(depCode)
);

DROP TABLE student;

CREATE TABLE student (
    stdNo VARCHAR2(10) NOT NULL,
    stdName VARCHAR2(30) NOT NULL,
    grade NUMBER(2) DEFAULT 4 CHECK(grade >= 1 AND grade <= 4),
    address VARCHAR2(30),
    birthday DATE,
    major VARCHAR2(30) NOT NULL,
    CONSTRAINT PK_stduent_stdNo PRIMARY KEY(stdNo),
    CONSTRAINT FK_student_major FOREIGN KEY(major) REFERENCES department(depCode)
);


/* 테이블 ALTER 연습 문제 */

-- 1. prdStock, prdDate 열 추가
ALTER TABLE product ADD (prdStock NUMBER(8), prdDate Date);

-- 2. prdCompany 열 기본 추가 NOT NULL로 변경
ALTER TABLE product ADD prdCompany VARCHAR2(10);
ALTER TABLE product MODIFY (prdCompany DEFAULT 'c' NOT NULL);

-- 3. pubPhone, pubAddress 열 추가
ALTER TABLE publisher ADD (pubPhone NUMBER(10), pubAddress VARCHAR(30));

-- 4. pubPhone 열 삭제
ALTER TABLE publisher DROP COLUMN pubPhone;


/* INSERT 연습 문제 */

-- 1. 속성과 값을 모두 나열하는 방법
INSERT INTO student(stdNo, stdName, grade, birthday, major) VALUES('2016001', '홍길동', 4, '1997-01-01', '1');

-- 2. 값만 나열하는 방법
INSERT INTO student VALUES('2015002', '성춘향', 3, 'korea', '1996-12-10', '3');

-- 3. 나머지는 전체 한 번에 저장
INSERT ALL
    INTO student VALUES('2014004', '이몽룡', 2, 'korea', '1996-03-03', '2')
    INTO student VALUES('2016002', '변학도', 4, 'korea', '1995-05-07', '1')
    INTO student VALUES('2015003', '손흥민', 3, 'korea', '1997-11-11', '2')
SELECT *
FROM DUAL;

SELECT * FROM student;
