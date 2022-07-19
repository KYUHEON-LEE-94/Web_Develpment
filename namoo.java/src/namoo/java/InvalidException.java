package namoo.java;

public class InvalidException extends Exception {

	
//	필요에 따라 속성 추가
//	int code;
	
	public InvalidException() {
		this("예기치않은 에러가 발생하였습니다. 관리자(홍길동)에게 문의바랍니다.");
	}
	
	public InvalidException(String message) {
		super(message);
	}
	
	
	
	
}
