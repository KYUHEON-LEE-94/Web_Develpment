package namoo.springjpa.domain.member.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "member_history")
@SequenceGenerator(name = "member_history_seq_gen", sequenceName = "member_history_seq", allocationSize = 1)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MemberHistory {
	@Id
	@Column(name = "history_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_history_seq_gen")
	private Long id;
	private String message;
	@ManyToOne
	@JoinColumn(name = "member_id") // 테이블 외래키 설정
	private Member member;
}
// 시퀀스 생성 : create sequence member_history_seq;
