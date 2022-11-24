package namoo.springjpa.domain.member.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
//DB의 데이터베이스와, 자바의 클래스명이 일치하지않을 경우 mapping할때 사용
	//unique 제약조건 추가할때 사용하는게 uniqueConstraints
@Table(name = "member", uniqueConstraints = { @UniqueConstraint(name = "member_name_uk", columnNames = { "name" }) })
@DynamicInsert  //Default로 되어있는 컬럼은 동적으로 넣어주세요~
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Member {
//DB에 테이블이 없는 상태에서 Entity Class를 만들면, 자동으로 테이블도 만들어주는 기능이 있음 -> 근데 거의 쓸일없음
	
	@Id
	@Column(name = "id", length = 10)
	private String id;
	
	@Column(name = "password", nullable = false, length = 10)
	private String password;
	
	@Column(name = "name", nullable = false, length = 20)
	private String name;
	
	@Column(name = "age", nullable = false)
	private Integer age;
	
	@Column(name = "regdate", columnDefinition = "DATE default sysdate")
	private Date regdate;
}
