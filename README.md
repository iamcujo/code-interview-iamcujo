## 서버 개발자 과제

#### 안내
* 진행 방법
  * 이 저장소를 포크해 주세요. 
  * 과제 완료 후 `main` 브랜치로 풀 리퀘스트합니다.
  * 리뷰어는 `seokhoon`을 지정해 주세요.
  * 과제 관련해 궁금한 점은 메일(seokhoon@huray.net)로 문의 바랍니다.

#### 세부 사항
* 기술 요건
  * Java 8
  * Database (DB 종류는 무관합니다만 H2 추천합니다)
  * jdbc driver

* 개발 요건
  * Database connection Pool 을 직접 구현합니다.
  * Database 에 User 테이블을 생성합니다.
  * User 테이블은 id, name, created_date 필드가 있습니다.
  * 각 필드(컬럼) 의 type과 size는 자유 입니다.

#### 구현 내용
  * Connection Pool
    * Pool을 통해 Database connection을 미리 생성합니다. size 는 자유 입니다.
  * User CRUD 서비스 구현
    * DB User 테이블에 사용자 정보에 대한 CRUD 서비스를 구현합니다.
    * DB 처리중 오류 발생시 transaction에 의해 rollback 되는 코드가 있어야 합니다.
    * DB 처리 후, commit 코드가 있어야 합니다.
  * 테스트
    * CRUD 서비스에 대한 테스트 코드를 작성 합니다.
