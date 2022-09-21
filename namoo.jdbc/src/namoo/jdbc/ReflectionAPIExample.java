package namoo.jdbc;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;

public class ReflectionAPIExample {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		String string = "리플렉션이 뭐예요?";
		//인스턴스가 아닌 이 인스턴스의 클래스인 'String'클래스에 대한 정보를 얻고싶은 상황
		//String 클래스에 대한 클래스 정보는 힙 영역 어딘가에 생성되어잇고
		//이 정보에 접근하려면 아래와 같은 방법으로 접근
		 Class c = string.getClass();
		 String className = c.getName();
		 System.out.println(className);
		 System.out.println(c.getSuperclass());
		 //접근 제어자는 무엇?? -> 숫자로 나옴
		 System.out.println(c.getModifiers());
		 // Constructor라는 클래스가 존재..
		 Constructor[] cons = c.getConstructors();
		 for (Constructor constructor : cons) {
			System.out.println(constructor);
		}
		// Method라는 클래스가 존재..
		Method[] methods = c.getMethods();
		for (Method method : methods) {
			System.out.println(method);
		}
		
		Class c2 = Class.forName("java.lang.Integer");
		System.out.println(c2.getName());
		
		//객체 동적 생성
		//Class c2 = Class.forName(변수입력가능);
		Integer inte = (Integer) c2.newInstance();
		System.out.println(inte);
		
		Class c3 = HashMap.class;
		c3.newInstance();
		
		
	}
}
