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
public class MemberSearchCondition {
private String id;
private String name;
private Integer age;
}
