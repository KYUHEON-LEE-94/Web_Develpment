package namoo.java;

public class InterfaceExample {

	public static void main(String[] args) {
//		인터페이스는 추상클래스와 마찬가지로 객체 생성이 되진 않지만
//		타입 선언은 가능하다.
		Weapon weapon = new Gun();
		weapon.attack();
		weapon = new Sword();
		weapon.attack();

		
		System.out.println(Weapon.WEIGHT);
		
	}


	
}
