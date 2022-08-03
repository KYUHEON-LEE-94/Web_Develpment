package namoo.thread;

public class CarRace {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("자동차 경주를 시작합니다.");
		System.out.println("경주 준비");
		
		Car car1 = new Car("BMW");
		Car car2 = new Car("아우디");	
		Car car3 = new Car("벤츠");	
		Car car4 = new Car("포르쉐");	
		Car car5 = new Car("제네시스");
		System.out.println("출발!");

		car1.start();
		car2.start();
		car3.start();
		car4.start();
		car5.start();
		
		car1.join();
		car2.join();
		car3.join();
		car4.join();
		car5.join();
			
		System.out.println("경주 끝");

	}

}
