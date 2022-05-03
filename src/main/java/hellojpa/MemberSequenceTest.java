package hellojpa;

import javax.persistence.*;

@Entity
// allocationSize = 50 (default 값)
// allocationSize를 기준으로 순차적으로 시퀀스 하나씩 높여가면서 id로 부여한다. (메모리에서)
// 만약 51에 도달하면 다시 DB로부터 그 다음 시퀀스를 받아오게 되는 식.
// 1 ~ 50 까지 시퀸스를 ID 로 부여할 때는 call next value for MEMBER_SEQ 쿼리가 실행되지 않는다. (성능 개선)
@SequenceGenerator(
        name = "MEMBER_SEQ_GENERATOR", // 제네레이터 이름
        sequenceName = "MEMBER_SEQ", // 매핑할 데이터베이스 시퀸스 이름
        initialValue = 1, allocationSize = 50)
public class MemberSequenceTest {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
        generator = "MEMBER_SEQ_GENERATOR")
    private Long id;

    @Column(name = "name", nullable = false)
    private String username;

    public MemberSequenceTest() {}

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
}
