## Spring boot + H2 �̿��� CRUD

|��� ���|
|----------------|
|Java 8|
|H2 Databse|
|jdbc driver|
|                |

> DB ó���� transaction �� ���� rollback, commit �� `@Transactional` ���.

�� ������̼��� �׽�Ʈ���̽��� �޸� �׽�Ʈ�� ������ �� Ʈ������� �����ϰ�,
DB �� �����͸� INSERT �� �ϰ� �׽�Ʈ�� ������ �� rollback() ó�� ��.

------------
> �׽�Ʈ�ڵ� /hurayUser/src/main/java/com/iamcujo/hurayUser/controller/BoardControllerTest.java
------------
#### USER ���̺� ���� SQL
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
> CRUD �׽�Ʈ�� POSTMAN ��� ���̵�

##### ��ȸ
(GET) http://localhost:8080/api/board/
##### ����ȸ
(GET) http://localhost:8080/api/board/{id}
##### ���
(POST) http://localhost:8080/api/board
{
"name"  :  "ȫ�浿"
}
##### ����
(POST) http://localhost:8080/api/board/{�����Ϸ���id}
{
"name"  :  "�����Ϸ����̸�"
}
##### ����
(DELETE) http://localhost:8080/api/board/{�����Ϸ���id}