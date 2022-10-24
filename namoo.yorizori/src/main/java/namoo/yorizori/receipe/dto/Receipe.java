package namoo.yorizori.receipe.dto;

/*
 * 사용자 정보 저장을 위한 자바 빈
 */
public class Receipe {
	private int receipeId, bookId, receipeTime, receipeLevel;
	private String receipeName, Ingredients, ImgContType, ImgFileName, WriterId;
	
	public Receipe() {}


	public Receipe(int receipeId, int bookId, int receipeTime, int receipeLevel, String receipeName, String ingredients,
			String imgContType, String imgFileName, String writerId) {
		super();
		this.receipeId = receipeId;
		this.bookId = bookId;
		this.receipeTime = receipeTime;
		this.receipeLevel = receipeLevel;
		this.receipeName = receipeName;
		Ingredients = ingredients;
		ImgContType = imgContType;
		ImgFileName = imgFileName;
		WriterId = writerId;
	}









	@Override
	public String toString() {
		String str = " [Receipe] "+"receipeId: "+receipeId+" bookId: "+bookId+" receipeTime: "+receipeTime+" receipeLevel: "+receipeLevel +"receipeName "+receipeName;
		return str;
		
	}
	
	
}
