package namoo.yorizori.user.dto;

/*
 * 사용자 정보 저장을 위한 자바 빈
 */
public class User {
	private String id, name, passwd, email, regdate;
	
	public User() {}

	
	
	public String getRegdate() {
		return regdate;
	}



	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}



	public User(String id, String name, String passwd, String email, String regdate) {
		super();
		this.id = id;
		this.name = name;
		this.passwd = passwd;
		this.email = email;
		this.regdate = regdate;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		String str = " [Student] "+"id: "+id+" name: "+name+" passwd: "+passwd+" email: "+email +"regdate "+regdate;
		return str;
		
	}
	
	
}
