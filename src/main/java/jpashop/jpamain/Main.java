package jpashop.jpamain;

import jpashop.domain.Address;
import jpashop.domain.Member;
import jpashop.domain.Period;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {



//            Address address = new Address("city", "street", "10000");
//
//            Member member1 = new Member();
//            member1.setName("Hello");
//            member1.setHomeAddress(address);
//            em.persist(member1);
//
//            // 의도 -> 첫 번째 멤버의 address 만 New City 로 바꾸고 싶다 ?
//            // 부작용 발생 -> 두 번째 멤버의 address city 또한 New City 로 바뀐다. (임베디드 값 타입은 공유되기 때문)
//            // 이런 사이드 이펙트를 피할려면 값을 복사해서 넣어야하는데, 이걸 컴파일 레벨에서 잡을 수 있는 방법이 없기 때문에
//            // 공유 참조를 항상 피할 수는 없다. (실수할 가능성이 매우 높음)
//            // 이 경우 임베디드 값 객체의 Setter 를 없애거나 Setter 를 private 로 막아서 불변 객체로 만들어주면 원천 차단이 가능하다.
////            member1.getHomeAddress().setCity("New City");
//
//            // Setter 가 없다면 값을 어떻게 바꿀 수 있나 ?
//            // 이렇게 바꾸고 싶은 값만 바꾸고 나머지는 Getter 를 통해 객체를 새로 셋팅하고, member1 주소를 아예 새로 갈아끼워야 한다.
//            Address change_city = new Address("change city", address.getStreet(), address.getZipcode());
//            member1.setHomeAddress(change_city);

            tx.commit();
        } catch(Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
