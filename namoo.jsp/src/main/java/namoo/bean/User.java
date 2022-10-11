package namoo.bean;

/*
 * 사용자 정보 저장을 위한 자바 빈
 */
public class User {
	private String id, name, passwd, email;
	
	public User() {}

	
	
	public User(String id, String name, String passwd, String email) {
		super();
		this.id = id;
		this.name = name;
		this.passwd = passwd;
		this.email = email;
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
		String str = " [Student] "+"id: "+id+" name: "+name+" passwd: "+passwd+" email: "+email;
		return str;
		
	}
	
	
}
