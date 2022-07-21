package namoo.standardAPI;

public class ObjectExample {
	public static void main(String[] args) {
		Object object = new Object();
		Object object2 = new Object();
		System.out.println(object.toString());
		System.out.println(object2.toString());
		
		System.out.println(object.equals(object2));
		System.out.println(object == object2);
		
		//->오브젝트 객체는 주소를 비교
		
		String name = "이규헌";
		String name2 = "이규헌";
		System.out.println(name.hashCode());
		System.out.println(name2.hashCode());
		System.out.println(name.equals(name2));
		System.out.println(name == name2);
		//--> String은 내용 비교
		
		Account account = new Account("1111","이규헌",111,1000);
		Account account2 = new Account("1111","이규헌",111,1000);
		System.out.println(account.equals(account2));
		
		//clone
		
		try {
			Account account3 = (Account)account.clone();
			System.out.println(account3.toString());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
