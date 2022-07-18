package namoo.java;

/**
 * 모든 도형이 반드시 구현해야 하는 메소드 선언
 * 수직적 규약 역할
 * @author Lee KyuHeon
 *
 */

public abstract class Shape {
	
	protected double x, y;
	
	public abstract void draw();
	
	public abstract double getLength();
	
	public abstract double getArea();
	
	public void print() {
		System.out.println("도형입니다.");
	}
	
	
	
}
