# basic-jpa-ch01

1. persistence.xml
- JPA는 persistence.xml을 사용해서 필요한 설정 정보를 관리
- META-INF/persistence.xml 클래스 패스 경로에 위치하면 자동으로 인식
- 일반적으로 연결할 데이터베이스 당 하나의 영속성 유닛(persistence-unit)을 등록

2. 매핑 애노테이션
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
