package namoo.springbasic.core;

import org.springframework.stereotype.Component;

@Component
public class Gun implements Weapon {

	@Override
	public void attack() {
		System.out.println("총을 쏜다 탕탕");
	}

}
