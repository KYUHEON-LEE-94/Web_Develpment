package namoo.springbasic.core;

import org.springframework.stereotype.Component;

@Component
public class Sword implements Weapon {

	@Override
	public void attack() {
		System.out.println("칼을 휘두른다 붕붕~");
	}

}
