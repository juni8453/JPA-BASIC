//package inheritanceEx;
//
//import javax.persistence.*;
//
//@Entity
//
//// 1. 조인 전략
////@Inheritance(strategy = InheritanceType.JOINED)
//
//// 2. 싱글 테이블 전략
//// 싱글 테이블 전략은 @DiscriminatorColumn 어노테이션이 없어도 DTYPE 이 자동으로 생성해준다.
////@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//
//// 3. 각 엔티티마다 테이블 생성 전략
//// 각 엔티티마다 테이블이 따로 있으므로 이 전략에서는 @DiscriminatorColumn 어노테이션이 사실상 필요가 없다.
//// 부모 타입으로 조회했을 때 모든 테이블을 뒤져야하기 때문에 상당히 비효율적이다.
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//
//// 아래 어노테이션을 넣어주면 디폴트로 엔티티 명이 컬럼으로 들어가게 된다. (DTYPE)
//@DiscriminatorColumn
//public abstract class Item {
//
//    @Id @GeneratedValue
//    private Long id;
//
//    private String name;
//    private int price;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getPrice() {
//        return price;
//    }
//
//    public void setPrice(int price) {
//        this.price = price;
//    }
//}
