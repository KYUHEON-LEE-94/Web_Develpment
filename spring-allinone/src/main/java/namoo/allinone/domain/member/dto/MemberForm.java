package namoo.allinone.domain.member.dto;

import java.util.Date;
/**
 * 회원가입 정보를 받기위한 폼을 위한 Bean
 */

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
public class MemberForm {
	
	@NotBlank(message = "회원 아이디는 필수입니다.")
	@Pattern(regexp="[a-zA-Z1-9]{6,12}", message = "아이디는 영어와 숫자로 포함해서 6 ~ 12자리 사이로 입력해주세요.")
	private String id;
	
	@NotBlank(message = "회원 비밀번호는 필수입니다.")
	@Size(min=4, max=6, message = "비밀번호는 4~6자리 사이로 입력해 주세요.")
	private String password;
	
	@NotBlank(message = "회원 이름은 필수입니다.")
	private String name;
	
	@NotNull(message = "회원 나이는 필수입니다.")
	@Max(value = 100, message = "나이는 100을 초과할 수 없습니다.")
	private Integer age;
	
	@Email(message = "이메일 형식을 맞춰주세요.")
	private String email;
	
	private String introduction;
	private Date regdate;
}

/*
 * 주요 애노테이션.............
// 문자열 관련
@NotNull // null 불가능
@NotEmpty // null, 빈 문자열(공백 포함 가능) 불가
@NotBlank // null, 빈 문자열, 공백 포함한 문자열 불가
@Size(min=?, max=?) // 최소 길이, 최대 길이 제한
@Null // null만 가능 
​
// 숫자 관련
@Positive // 양수만 허용
@PositiveOrZero // 양수와 0만 허용
@Negative // 음수만 허용
@NegativeOrZero // 음수와 0만 허용
@Min(?) // 최소값 제한
@Max(?) // 최대값 제한
​
// 정규표현식 관련
@Email // 이메일 형식만가능 (기본 제공)
@Pattern(regexp="?") // 정규식 사용
*/
