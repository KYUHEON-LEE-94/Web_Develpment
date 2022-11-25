package namoo.springjpa.domain.guestbook.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@SequenceGenerator(name = "guestbook_seq_gen", // 시퀀스 생성 이름
		sequenceName = "guestbook_seq", // DB에서 시퀀스 이름
		allocationSize = 1) // JPA에서 가상으로 관리할 시퀀스 할당 범위(기본값은 50이며, 1로 설정하는 경우 매번 insert시마다 DB의 시퀀스 사용)
@DynamicInsert
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Guestbook {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "guestbook_seq_gen")
	private Long guestbookId;
	private String writer;
	private String contents;
	private LocalDateTime regdate;

}
