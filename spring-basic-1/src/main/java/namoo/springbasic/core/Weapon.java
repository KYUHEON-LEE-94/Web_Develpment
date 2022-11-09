package namoo.springbasic.core;
/**
 * 스프링과 일반 자바와의 기본 구조 차이 이해를 위한 Test 패키지
 * @author Lee KyuHeon
 *
 */
public interface Weapon {
	public void attack();
}

//확장에는 열려있으나, 변경에는 닫혀있어야 한다 OCP를  따르지 못하고 있음 -> 확장에 열려있으나, 변경에 닫혀있지는 못함