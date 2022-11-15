package namoo.springmvc.web.file.controller;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * 업로드 파일 포함 form파라미터 저장용 객체
 */
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MemberForm {
	private String uploader;
	private String description;
	/*
	 * 파일 업로드 다운을 위해서는 MultipartFile 객체를 사용해야함
	 */ 
	private MultipartFile uploadfile;
	private List<MultipartFile> uploadfiles;
}
