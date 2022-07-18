package namoo.java;

public class Circle extends Shape {
	
	private double radian;
	

	public Circle(double x, double y, double radian) {
		this.x = x;
		this.y = y;
		this.radian = radian;
	}
	
	//setter getter 생략

	public Circle() {
		this(0.0,0.0,0.0);
	}

	@Override
	public void draw() {
		System.out.println("원("+x+","+y+","+radian+")을 그립니다.");

	}

	@Override
	public double getLength() {
		return 2*Math.PI*radian;
	}

	@Override
	public double getArea() {
		
		return Math.PI * Math.pow(radian, 2);
	}

}
