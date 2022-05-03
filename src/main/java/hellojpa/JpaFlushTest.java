//package hellojpa;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
//
//public class JpaFlushTest {
//    public static void main(String[] args) {
//
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//
//        // 트랜잭션 시작
//        tx.begin();
//
//        try {
//            Member member = new Member(200L, "member200");
//            em.persist(member);
//
//            // 미리 쿼리를 좀 보고 싶다.
//            // 이럴 땐 flush() 를 강제하면, 트랜젝션 커밋 전에 쿼리를 살펴볼 수 있다.
//            // 항상 flush 이후 DB 에 쿼리가 날아가게 된다.
//            em.flush();
//
//            System.out.println("=================");
//            tx.commit();
//
//        } catch (Exception e) {
//            tx.rollback();
//        } finally {
//            em.close();
//        }
//
//        emf.close();
//    }
//}
