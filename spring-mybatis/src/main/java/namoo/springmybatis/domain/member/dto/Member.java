package namoo.springmybatis.domain.member.dto;

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
private String id;
private String passwd;
private String name;
private Integer age;
}