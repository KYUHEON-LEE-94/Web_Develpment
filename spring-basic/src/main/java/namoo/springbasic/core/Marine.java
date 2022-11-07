package namoo.springbasic.core;

/**
 * 개발자가 직접  객체간의 관계를 설정해주고 있음 IoC가 아님
 *
 */

public class Marine implements Unit {
	private String name;
	private int level;
	
	//이 클래스가 사용하는 무기를 Mapping 하기 위해서는 인터페이스로,
	private Weapon weapon;
	
	

	public Marine() {}

	public Marine(String name, int level, Weapon weapon) {
		this.name = name;
		this.level = level;
		this.weapon = weapon;
	}

	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	@Override
	public void offense() {
		weapon.attack();
	}



	@Override
	public void defense() {
		System.out.println("막아라~");
	}
	
	
	
	@Override
	public String toString() {
		return "Marine [name=" + name + ", level=" + level + ", weapon=" + weapon + "]";
	}

}
