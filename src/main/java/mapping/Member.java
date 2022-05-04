//package mapping;
//
//import javax.persistence.*;
//
//@Entity
//public class Member {
//
//    @Id @GeneratedValue
//    @Column(name = "MEMBER_ID")
//    private Long id;
//
//    private String name;
//
//    // 연관관계의 주인 왜?
//    // 외래키가 있는 곳을 주인으로 정하자 (가이드)
//    // 1:M 에서 M(ManyToOne) 쪽이 외래키를 가지고 있으며 주인이 되는 편이 여러가지로 좋다 (정확히는 아직 모름)
//    @ManyToOne
//    @JoinColumn(name = "TEAM_ID")
//    private Team team;
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
//    public Team getTeam() {
//        return team;
//    }
//
//    public void setTeam(Team team) {
//        this.team = team;
//    }
//}
