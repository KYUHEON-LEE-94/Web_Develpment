package namoo.springbasic.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * 개발자가 직접  객체간의 관계를 설정해주고 있음 IoC가 아님
 *
 */
//나 AutoAppConfig가 관리하는 Bean Component야~ -> Component만으로는 Spring컨테이너에 올라온 객체들 간의 DI가 형성이 안되어있음
		//이 클래스 이름의  소문자로 등록됨 marine
@Component
public class Marine implements Unit {
	private String name;
	private int level;
	
	//Marine과 의존 대상임 -> 여기에 Autowired를 등록하면 DI 성립
	@Autowired 
	@Qualifier("sword")   //Weapon을 상속하는 개체가 3개가 있는데, 이중 어떤걸로 식별할거니?
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
