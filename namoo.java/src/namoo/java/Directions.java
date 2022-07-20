package namoo.java;

public enum Directions {
	
	
	NORTH("북"), EAST("동"), WEST("서"), SOUTH("남");

	String name;
	
	Directions(String name) {
		this.name = name;
	}
	
	
	public String getName() {
		return name;
	}
	
}


