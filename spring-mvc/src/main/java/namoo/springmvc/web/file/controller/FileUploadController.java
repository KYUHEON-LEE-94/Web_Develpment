package namoo.springmvc.web.file.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class FileUploadController {
	// application.properties에 설정된 파일 경로를 참조하는 방법
	// 1. @Value("D:/WebDevel/workspace/spring-mvc/file-upload/")
	// 2. @Value("${file.dir}") : el표현식을 사용해서 String변수에 경로를 자동으로 넣어줌

	@Value("${file.dir}")
	private String location;

	//화면을 보여주는 메서드
	@GetMapping("/upload")
	public String uploadForm() {
		return "upload/form";
	}

	@PostMapping("/upload")
	public String uploadFile(@RequestParam String uploader,
						//Servlet의 Part 클래스를 확장한 클래스
			@RequestParam MultipartFile uploadfile) throws IOException {

		log.info("업로더 = {}", uploader);
		log.info("multipartFile = {}", uploadfile);
		
		if (!uploadfile.isEmpty()) {
								//지정해놓은 경로에 지금 입력받는 파일 이름을 더해
			String fullPath = location + uploadfile.getOriginalFilename();
			log.info("파일 저장 fullPath = {}", fullPath);
			uploadfile.transferTo(new File(fullPath));
			//Transfer the received file to the given destination file. 
		}
		return "upload/form";
		//그냥 입력화면으로 일단 보내자
	}
}
