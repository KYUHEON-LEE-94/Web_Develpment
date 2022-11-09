package namoo.springbasic.core;

/*
 * OCP, DIP 원칙을 그나마 지키기위한 조금더 발전된 형태
 */

public class AdvancedApplication {

	public static void main(String[] args) {	
		AppConfig apppConfig = new AppConfig();
		Unit unit = apppConfig.unit();
		
		unit.offense();
		unit.defense();



	}

}
