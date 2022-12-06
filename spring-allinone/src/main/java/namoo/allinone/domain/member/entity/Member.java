package namoo.allinone.domain.member.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.DynamicInsert;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@DynamicInsert
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Member {
	@Id
	@Column(name="member_id")
	private String id;
	private String password;
	private String name;
	private Integer age;
	private LocalDateTime regdate;
}

/*
CREATE TABLE member (
    member_id    VARCHAR2(10),
    password     VARCHAR2(10) NOT NULL,
    name         VARCHAR2(20) NOT NULL,
    age          NUMBER(3)    NOT NULL,
    regdate      DATE DEFAULT SYSDATE
);

ALTER TABLE member
    ADD ( CONSTRAINT member_id_pk PRIMARY KEY(member_id));
*/

