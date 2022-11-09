package namoo.springbasic.guestbook.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Guestbook {
	
	private String writer;
	private String message;
	

}
