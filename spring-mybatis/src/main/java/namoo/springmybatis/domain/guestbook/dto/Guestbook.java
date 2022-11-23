package namoo.springmybatis.domain.guestbook.dto;

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
public class Guestbook {
	private String writer;
	private String contents;
	private String regdate;
}