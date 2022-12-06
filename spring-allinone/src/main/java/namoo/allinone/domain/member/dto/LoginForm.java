package namoo.allinone.domain.member.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class LoginForm {
	
	@NotBlank(message = "아이디를 입력하여 주세요.")
	@Pattern(regexp="[a-zA-Z1-9]{6,12}", message = "아이디는 영어와 숫자로 포함해서 6 ~ 12자리 사이로 입력해주세요.")
	private String id;
	@NotBlank(message = "비밀번호를 입력하여 주세요.")
	@Size(min=4, max=6, message = "비밀번호는 4~6자리 사이로 입력해 주세요.")
	private String password;
	//ID 세이브 여부
	private Boolean remember;
	//회원 목록을 요청할 경우 로그인이 안되어있을 때 -> 다시 로그인하고 회원목록으로 페이지를 열어주기 위한 변수
	private String redirect;
}
