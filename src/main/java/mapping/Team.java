//package mapping;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//public class Team {
//
//    @Id @GeneratedValue
//    @Column(name = "TEAM_ID")
//    private Long id;
//
//    private String name;
//
//    // Team 객체 기준으로 Team = One, Members = Many
//    // 연관관계의 주인만이 외래키를 관리 (등록 수정 읽기 가능), 주인이 아닌쪽은 읽기만 가능
//    // 주인이 아니라면 mappedBy 속성으로 주인을 지정해야 한다.
//    // 즉, 이 예제에서는 Team team 값이 연관관계의 주인이 되므로 mappedBy = "team" 으로 지정한 것이다.
//    @OneToMany(mappedBy = "team")
//    private List<Member> members = new ArrayList<>();
//
//    // 연관관계 매핑 편의 메서드
//    public void addMember(Member member) {
//        // 해당 멤버 객체의 팀 레퍼런스 추가 후 members 에 추가
//        members.add(member);
//        member.setTeam(this);
//    }
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
//    public List<Member> getMembers() {
//        return members;
//    }
//
//    public void setMembers(List<Member> members) {
//        this.members = members;
//    }
//}
