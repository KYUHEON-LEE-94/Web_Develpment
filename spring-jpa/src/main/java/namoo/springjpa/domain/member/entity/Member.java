package namoo.springjpa.domain.member.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import namoo.springjpa.domain.team.entity.Team;

@Entity
@DynamicInsert
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Member {
	@Id
	@Column(name = "MEMBER_ID")
	private String id;
	@ManyToOne
	@JoinColumn(name = "TEAM_ID")
	private Team team;
	private String password;
	private String name;
	private Integer age;
	private LocalDateTime regdate;
}