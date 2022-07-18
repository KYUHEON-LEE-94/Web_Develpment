package namoo.java;

public class ShapeExample {

	public static void main(String[] args) {
//		추상클래스는 생성할 수 없다.
//		Shape shape = new Shape();

		Circle won = new Circle(10,20,15);
		System.out.println("원의 둘레: "+won.getLength());
		System.out.println("원의 면적: "+won.getArea());
		
//		추상클래스는 객체 생성이 되진 않지만, 타입 선언으로는 가능하다(Up캐스팅)		
		Shape shape = new Circle(10,30,40);
		System.out.println("원의 둘레: "+shape.getLength());
		System.out.println("원의 면적: "+shape.getArea());
		shape = new Rectangle(10,20,30,40);
		System.out.println("사각형의 둘레: "+shape.getLength());
		System.out.println("사각형의 면적: "+shape.getArea());
		
		
	}

}
