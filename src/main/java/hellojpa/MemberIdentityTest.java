package hellojpa;

import javax.persistence.*;

@Entity
public class MemberIdentityTest {

    // 직접 기본 키를 셋팅 시 @Id 만 사용한다.
    @Id

    // AUTO 옵션은 데이터 베이스 방언에 맞춰서 기본 키가 생성된다.
    // IDENTITY 옵션은 AUTO_INCREMENT (MySQL 에서는)
    // SEQUENCE 옵션은 주로 오라클 DB 에서 사용, 시퀀스에서 저장된 값을 가져와서 다음 시퀀스 값을 셋팅한다.
    // Not Null, 유일, 변하면 안된다. 하지만 먼 미래까지 이 조건을 만족하는 자연키는 찾기 어렵기 때문에 대체키를 찾아 사용해야한다.
    // 주민번호도 기본 키로 적절하지 않다. (나라에서 주민번호를 저장하면 안된다.. 라고 해서 난리난 썰)
    // 권장 : Long 형 + 대체 키 + 키 생성전략 사용

    // IDENTITY 전략은 예외적으로 em.persist() 메서드 실행 후 바로 쿼리가 실행된다.
    // 왜냐하면, DB 의 PK 값을 가지고 영속 컨텍스트 내부의 1차 캐시 값을 조회하는데, IDENTITY 는 DB 에 Insert 가 되기 전 까지는
    // PK 값을 알 수가 없다. 그래서 commit() 때가 아닌, persist() 메서드 실행 시 바로 쿼리가 실행되고, 그에 따른 PK 값을 가지고
    // 1차 캐시 값을 조회한다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public MemberIdentityTest() {}
}
