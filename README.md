## Spring boot + H2 이용한 CRUD

|기술 요건|
|----------------|
|Java 8|
|H2 Databse|
|jdbc driver|
|                |

> DB 처리중 transaction 에 대한 rollback, commit 은 `@Transactional` 사용.

이 어노테이션을 테스트케이스에 달면 테스트를 실행할 때 트랜잭션을 실행하고,
DB 에 데이터를 INSERT 를 하고 테스트를 종료할 때 rollback() 처리 함.

------------
> 테스트코드 /hurayUser/src/main/java/com/iamcujo/hurayUser/controller/BoardControllerTest.java
------------
#### USER 테이블 생성 SQL
`CREATE TABLE USER
( "ID" NUMBER(8) PRIMARY KEY,
  "NAME" VARCHAR2(16),
  "CREATED_DATE" VARCHAR(14)
);`

`CREATE SEQUENCE id
START WITH 1
INCREMENT BY 1
NOMAXVALUE
NOMINVALUE;`

------------
> CRUD 테스트시 POSTMAN 사용 가이드

##### 조회
(GET) http://localhost:8080/api/board/
##### 상세조회
(GET) http://localhost:8080/api/board/{id}
##### 등록
(POST) http://localhost:8080/api/board
{
"name"  :  "홍길동"
}
##### 수정
(POST) http://localhost:8080/api/board/{수정하려는id}
{
"name"  :  "변경하려는이름"
}
##### 삭제
(DELETE) http://localhost:8080/api/board/{삭제하려는id}