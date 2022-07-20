package namoo.java;

public class EnumExample {

	public static void move(Directions directions){
		switch (directions) {
		case NORTH: System.out.println("북"); break;
		case SOUTH: System.out.println("남"); break;
		case EAST: System.out.println("동"); break;
		case WEST: System.out.println("서"); break;
		//스위치문에는 String,int,Enum만 쓸수있음
		
		}
	}
	
	public static void main(String[] args) {
		move(Directions.NORTH);

		Directions[] dir = Directions.values();
				for (Directions directions : dir) {
					System.out.println(directions.getName());
				}
				
		String direct = "north";
		Directions d = Directions.valueOf(direct.toUpperCase());
		System.out.println(d);		
				
	}

}
