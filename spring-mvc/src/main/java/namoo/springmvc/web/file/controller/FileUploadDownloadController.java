package namoo.springmvc.web.file.controller;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;

/**
 * 다중 파일 업로드 및 다운로드 처리 컨트롤러
 * 
 * @author Lee KyuHeon
 *
 */
@Controller
@Slf4j
public class FileUploadDownloadController {

	@Value("${file.dir}")
	private String location;

	/*
	 * 업로드 파일 저장 및 관리하는 Bean
	 */
	@Autowired
	private FileStore fileStore;

	@GetMapping("/upload2")
	public String uploadForm() {
		return "upload/form2";
	}

	@PostMapping("/upload2")
	/*
	 * MemberForm Bean으로 쉽게 받고 사용
	 */
	public String uploadFiles(@ModelAttribute MemberForm memberForm, RedirectAttributes redirectAttributes)
			throws IOException {

//		log.info("업로드 파일: {}", memberForm.getUploadfile());
//		log.info("업로드 파일ᄃᄅ: {}", memberForm.getUploadfiles());
		
		//파일 업로드 한개만 일때
		UploadFile uploadFile = fileStore.storeFile(memberForm.getUploadfile());
		//파일 업로드 여러개 일때
		List<UploadFile> uploadFiles = fileStore.storeFiles(memberForm.getUploadfiles());

		log.info("원본파일명: {}", uploadFile.getUploadFileName());
		log.info("DB용 파일명: {}", uploadFile.getStoreFileName());
		
		
		// 데이터베이스에 오리지날파일명과 저장파일명 저장했다고 가정

		//리다이렉트하면서 quetyString 전달 
		redirectAttributes.addAttribute("uploader", memberForm.getUploader());
		redirectAttributes.addAttribute("file", uploadFile.getUploadFileName());
		return "redirect:upload-result";
	};

	@GetMapping("/upload-result")
	public String uploadResult() {
		return "upload/upload-result";
	}
	
	//-------------------------------- 다운로드 구역 ------------------------------------------------

	/*
	 * 디렉터리를 체크함으로서 다운로드할 목록을 보여주는 메서드
	 */
	@GetMapping("/downloads")
	public String download(Model model) {
		File directory = new File(location);
		File[] files = directory.listFiles();
		model.addAttribute("list", files);
		return "upload/downloads";
	}

	/*
	 * REST API형식으로 fileName 전달받음
	 */
	@GetMapping("/download/{fileName}")
	public ResponseEntity<Resource> download(@PathVariable String fileName) throws IOException {
		
		//Path를 동적으로 얻어올 수 있는 클래스와 메서드
		Path path = Paths.get(location + "/" + fileName);
		
		//경로에 대한 contetType을 동적으로 얻어옴
		String contentType = Files.probeContentType(path);
		
		//응답헤더를 설정할 수 있도록 제공하는 클래스
		HttpHeaders headers = new HttpHeaders();
		// 응답 헤더에 파일정보 설정
		headers.setContentDisposition(
				ContentDisposition.builder("attachment").filename(fileName, StandardCharsets.UTF_8).build());
		headers.add(HttpHeaders.CONTENT_TYPE, contentType);
		
		Resource resource = new InputStreamResource(Files.newInputStream(path));
		
		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
	}

	// 이미지를 웹상에서 보여주는 역할
	@GetMapping("/images/{name}")
	//body에 출력해주기 위해
	@ResponseBody
	public ResponseEntity<Resource> showImage(@PathVariable String name) throws IOException {
		
		Path path = Paths.get(location + "/" + name);
		
		String contentType = Files.probeContentType(path);
		
		Resource resource = new FileSystemResource(path);
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.add(HttpHeaders.CONTENT_TYPE, contentType);
		//MIME을 지정해줌
		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
	}
}
