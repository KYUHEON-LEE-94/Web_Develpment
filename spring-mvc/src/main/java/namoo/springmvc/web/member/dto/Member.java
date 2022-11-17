package namoo.springmvc.web.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Member {
	private String name, passwd, id;
	//Integer로 하면 0으로 초기화가 되지 않기 때문에 타임리프에 렌더링 할때 아무런 값도 안뜨게 됨
	private Integer age;
	
	
}
