package namoo.springmvc.web.file.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * 업로드 파일정보 (원본파일명, 저장파일명) 저장 빈
 * 중복방지용*
 */
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UploadFile {

	private String uploadFileName;
	private String storeFileName;
}
