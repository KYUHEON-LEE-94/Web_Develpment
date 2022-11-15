package namoo.springmvc.web.file.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/*
 * 업로드 파일 저장 및 관리하는 Bean
 */
@Component
public class FileStore {

	@Value("${file.dir}")
	private String location;

	//파일 경로+파일이름 get메서드
	public String getFullPath(String filename) {
		return location + filename;
	}

	
	/*
	 * 파일 여러개를 저장할때 메서드
	 */
	public List<UploadFile> storeFiles(List<MultipartFile> multipartFiles) throws IOException {
		
		List<UploadFile> storeFileResult = new ArrayList<UploadFile>();
		
		for (MultipartFile multipartFile : multipartFiles) {
			if (!multipartFile.isEmpty()) {
				// 업로드 파일 저장
				UploadFile uploadFile = storeFile(multipartFile);
				storeFileResult.add(uploadFile);
			}
		}
		return storeFileResult;
	}
	
	
	/*
	 * 파일 한개만 저장할때 메서드
	 */
	public UploadFile storeFile(MultipartFile multipartFile) throws IOException {
		
		if (multipartFile == null || multipartFile.isEmpty()) {
			return null;

		}
		
		String originalFilename = multipartFile.getOriginalFilename();
		String storeFileName = createStoreFileName(originalFilename);
		multipartFile.transferTo(new File(getFullPath(storeFileName)));
		
		//여기서 UploadFile객체를 반환함
		return new UploadFile(originalFilename, storeFileName);
	}

	/*
	 * DB에 저장할 무작위 파일명 생성 메서드
	 */
	private String createStoreFileName(String originalFilename) {
		String ext = extractExt(originalFilename);
		String uuid = UUID.randomUUID().toString();
		return uuid + "." + ext;
	}

	/*
	 * 파일 확장자명 추출 메서드
	 */
	private String extractExt(String originalFilename) {
		int pos = originalFilename.lastIndexOf(".");
		return originalFilename.substring(pos + 1);
	}
}
