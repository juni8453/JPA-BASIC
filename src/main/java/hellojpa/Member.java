//package hellojpa;
//
//import javax.persistence.*;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.Date;
//
//@Entity
//public class Member {
//
//    @Id
//    private Long id;
//
//    // DB 의 컬럼명은 name , 객체에서는 username 을 사용하는 것
//    // 여러가지 속성을 사용할 수 있다.
////    @Column(
////            name = "name",
////            insertable = true, updatable = true,
////            nullable = false,
////            length = 10,
////            columnDefinition = "Varchar(100) default 'EMPTY'")
//    @Column
//    private String username;
//
//    private Integer age;
//
//    // DB 에서 Enum 을 사용하고 싶을 떄
//    // 주의 사항
//    // EnumType.ORDINAL 은 Enum 의 순서를 DB 에 저장 (기본 값)
//    // Enum 클래스에 요구 사항이 언제든 변경될 수도 있기 때문에 사용하지 말자. (옛날 데이터 순서를 바꿀 수가 없다)
//    @Enumerated(EnumType.STRING)
//    private RoleType roleType;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createdDated;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date lastModifiedDate;
//
//    // 자바 8 이후 LocalDate, LocalDateTime 을 사용하는 경우 @Temporal 어노테이션이 필요가 없다.
////    private LocalDate testLocalDate;
////    private LocalDateTime testLocalDateTime;
//
//    // Varchar 을 넘는 큰 데이터 타입
//    // String 이면 clob 타입으로 생성
//    // 나머지는 blob 타입으로 생성
//    @Lob
//    private String description;
//
//    // 아무것도 매핑하기 싫을 때 사용하는 어노테이션
//   @Transient
//    private int tmp;
//
//    // JPA 엔티티는 기본생성자가 필요하다.
//    public Member() {}
//
//    public Member(Long id, String username) {
//        this.id = id;
//        this.username = username;
//    }
//}
