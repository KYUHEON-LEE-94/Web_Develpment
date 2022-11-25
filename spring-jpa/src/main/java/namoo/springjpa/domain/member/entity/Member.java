package namoo.springjpa.domain.member.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@DynamicInsert // SQL 디폴트 값 자동 입력
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Member {
	@Id
	private String id;
	private String passwd;
	private String name;
	private Integer age;
	private Date regdate;
}
