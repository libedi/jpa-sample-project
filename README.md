# basic-jpa-ch01

## 1. persistence.xml
- JPA는 persistence.xml을 사용해서 필요한 설정 정보를 관리
- META-INF/persistence.xml 클래스 패스 경로에 위치하면 자동으로 인식
- 일반적으로 연결할 데이터베이스 당 하나의 영속성 유닛(persistence-unit)을 등록

## 2. 매핑 애노테이션
- @Entity
  - 이 클래스를 테이블과 매핑한다고 JPA에게 알려줌.
  - 엔티티 클래스라고 함.
- @Table
  - 엔티티 클래스와 매핑할 테이블 정보를 알려줌.
- @Id
  - 필드를 테이블의 기본 키(primary key)에 매핑.
  - 식별자 필드라고 함.
- @Column
  - 필드를 컬럼에 매핑.
  - name 속성을 이용하여 테이블 컬럼에 매핑.
- 매핑정보가 없는 경우
  - 필드명을 사용해서 컬럼명에 매핑.
  - 데이터베이스가 대소문자 구분시 명시적으로 해줘야 한다.

## 3.  엔티티 매니저
- 엔티티를 저장, 수정, 삭제, 조회하는 등 엔티티와 관련된 모든 일을 처리.
- 엔티티를 처리하는 일종의 가상 데이터베이스.
- 엔티티 매니저 팩토리를 통해 생성.
- 엔티티 매니저는 데이터베이트 연결이 꼭 필요한 시점까지 커넥션을 얻지 않는다.
- 보통 트랜잭션 시작시 커넥션 획득.
- 동시성 문제가 발생하여 쓰레드간 공유 금지.

## 4. 엔티티 매니저 팩토리
- 엔티티 매니저를 생성.
- persistence.xml 에 있는 정보를 바탕으로 생성.
- thread-safe하며, 생성비용이 커 1개만 만들어서 여러 스레드에서 공유.
- 생성코드  
`
Persistence.createEntityManagerFactory("jpatest");
`
## 5. 영속성 컨텍스트
- 엔티티를 영구 저장하는 환경.
- 엔티티 매니저로 엔티티를 저장/조회하면, 엔티티 매니저는 영속성 컨텍스트에 엔티티를 보관/관리한다.
- 엔티티 매니저를 생성할 때 하나 만들어진다.
- 엔티티 매니저를 통해 접근 및 관리.
~~~java
EntityManage em = emf.createEntityManager();
em.persist(member);
~~~
## 6. 엔티티 생명주기
- 비영속 : 영속성 컨텍스트와 전혀 관계없는 순수 객체 상태.  
```java
Member member = new Member();
```
- 영속 : 영속성 컨텍스트가 관리하는 상태
~~~java
em.persist()
em.find() // or JPQL
em.merge()
~~~
- 준영속 : 영속성 컨텍스트에서 분리된 상태
~~~java
em.detach()
em.clear()
em.close()
~~~
- 삭제 :  엔티티를 영속성 컨텍스트와 데이터베이스에서 삭제한다.  
```java
em.remove(member);
```
