package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaDetachTest {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        // 트랜잭션 시작
        tx.begin();

        try {
            Member findMember = em.find(Member.class, 100L);
            findMember.setName("changeAAA");

            // 준영속 상태로 만들기 위해 detach() 메서드 사용
            // 따로 JPA 에서 관리하지 않기 때문에 Update 쿼리가 나가지 않는다.
            em.detach(findMember);

            // 1차 캐시의 객체들을 모두 지우는 clear()
            // em.clear();

            // 위에서 100L 의 PK 를 가지는 객체를 1차 캐시에서 지워버렸기 때문에
            // Select 쿼리가 2번 나가게 된다. (다시 영속성 컨텍스트로 객체를 올려야되기 때문)
            Member findMember2 = em.find(Member.class, 100L);

            System.out.println("=================");
            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
