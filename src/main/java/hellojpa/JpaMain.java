package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        // 트랜잭션 시작
        tx.begin();

        try {
            // 비영속 상태 (EntityManager 에서 관리 x)
            Member member = new Member();
            member.setId(101L);
            member.setName("HelloJPA");

            // 영속 상태로 전환 (아직 DB 저장 x)
            // Member Entity 는 현재 영속 상태이며 1차 캐시에 저장된 상태이다.
            em.persist(member);

            // 조회 시 먼저 1차 캐시를 뒤진다.
            // 1차 캐시 중 PK 값이 101인 데이터를 찾아낸다. 있다면 Select 문이 실행되지 않고도 조회할 수 있다.
            // 여기서는 1차 캐시에 PK 값이 101인 데이터가 있기 때문에 굳이 Select 문을 사용하지 않고도 조회한 것이다. (log 에 select 없음)
            Member findMember1 = em.find(Member.class, 101L);
            Member findMember2 = em.find(Member.class, 101L);

            System.out.println("findMember1.getId() = " + findMember1.getId());
            System.out.println("findMember1.getName() = " + findMember1.getName());

            // 같은 트랜잭션 내부에서 같은 똑같은 객체를 find() 하면, == 비교 시 true 를 반환받을 수 있다.
            System.out.println(findMember1 == findMember2);

            // 준영속 상태로 전환 (영속 상태에서 분리된 상태)
            // em.detach(member);

            // 트랜잭션을 커밋할 때 쓰기 지연 SQL 저장소에 저장된 데이터를 DB 로 전송한다.
            // 즉, JPA 는 항상 트랜잭션 커밋 시 쿼리가 무조건 날아간다.
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
