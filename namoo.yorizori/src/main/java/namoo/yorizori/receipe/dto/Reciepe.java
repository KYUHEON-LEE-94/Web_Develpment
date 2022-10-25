package namoo.yorizori.receipe.dto;

/*
 * 사용자 정보 저장을 위한 자바 빈
 */
public class Reciepe {
	private int receipeId, bookId, receipeTime, receipeLevel;
	private String receipeName, Ingredients, ImgContType, ImgFileName, WriterId;
	
	public Reciepe() {}


	public Reciepe(int receipeId, int bookId, int receipeTime, int receipeLevel, String receipeName, String ingredients,
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


	public int getReceipeId() {
		return receipeId;
	}


	public void setReceipeId(int receipeId) {
		this.receipeId = receipeId;
	}


	public int getBookId() {
		return bookId;
	}


	public void setBookId(int bookId) {
		this.bookId = bookId;
	}


	public int getReceipeTime() {
		return receipeTime;
	}


	public void setReceipeTime(int receipeTime) {
		this.receipeTime = receipeTime;
	}


	public int getReceipeLevel() {
		return receipeLevel;
	}


	public void setReceipeLevel(int receipeLevel) {
		this.receipeLevel = receipeLevel;
	}


	public String getReceipeName() {
		return receipeName;
	}


	public void setReceipeName(String receipeName) {
		this.receipeName = receipeName;
	}


	public String getIngredients() {
		return Ingredients;
	}


	public void setIngredients(String ingredients) {
		Ingredients = ingredients;
	}


	public String getImgContType() {
		return ImgContType;
	}


	public void setImgContType(String imgContType) {
		ImgContType = imgContType;
	}


	public String getImgFileName() {
		return ImgFileName;
	}


	public void setImgFileName(String imgFileName) {
		ImgFileName = imgFileName;
	}


	public String getWriterId() {
		return WriterId;
	}


	public void setWriterId(String writerId) {
		WriterId = writerId;
	}


	@Override
	public String toString() {
		String str = " [Receipe] "+"receipeId: "+receipeId+" bookId: "+bookId+" receipeTime: "+receipeTime+" receipeLevel: "+receipeLevel +"receipeName "+receipeName;
		return str;
		
	}
	
	
}
