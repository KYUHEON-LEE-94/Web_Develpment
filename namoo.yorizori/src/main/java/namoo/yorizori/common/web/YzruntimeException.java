package namoo.yorizori.common.web;

/***
 * 사용자 정의 예외 런타임 클래스
 * 
 * @author Lee KyuHeon
 *
 */
public class YzruntimeException extends RuntimeException {
	// 로그인을 했을 때 어디로 돌아가느냐?
	private String redirectUrl;

	public YzruntimeException() {
	}

	// 메시지만 넣는 생성자 - 메시지만 보여주는 용도
	public YzruntimeException(String message) {
		super(message);
	}

	// 메시지와 url을 넣을 생성자 - 메시지 보여주고 이동시킬때
	public YzruntimeException(String message, String redirectUrl) {
		super(message);
		this.redirectUrl = redirectUrl;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

}
