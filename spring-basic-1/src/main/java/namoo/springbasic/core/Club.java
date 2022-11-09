package namoo.springbasic.core;

import org.springframework.stereotype.Component;

@Component
public class Club implements Weapon {

	@Override
	public void attack() {
		System.out.println("곤봉을 휘두른다 아뵤~");
	}

}
