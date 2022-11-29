package namoo.springjpa.domain.team.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import namoo.springjpa.domain.member.entity.Member;

@Entity
@SequenceGenerator(name = "team_seq_gen", sequenceName = "team_seq", allocationSize = 1)
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_seq_gen")
	@Column(name = "team_id")
	private Long id;
	private String name;
// mappedBy속성 : members에 등록되어 있는 Member의 team 속성에 매핑되었음을 의미
	@OneToMany(mappedBy = "team") //Team입장에서는 다수를 상대하는거기때문에 oneToMany
// 연관관계의 주인(Owner)이 Member의 team 임을 설정 - 왜? Team은 Member에게 FK당하고 있기때문에
// @JoinColumn 설정하지 않는다
	private List<Member> members = new ArrayList<Member>();
}