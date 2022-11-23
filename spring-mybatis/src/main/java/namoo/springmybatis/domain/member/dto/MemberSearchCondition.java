package namoo.springmybatis.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * 검색할 때 사용하는 Bean클래스
 */
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MemberSearchCondition {
	private String id;
	private String name;
	private Integer age;
}
