package namoo.yorizori.cookbook.dto;

public class Cookbook {
	private int bookId;
	private String bookName, bookDesc, authorId;
	
	public Cookbook() {}
	
	public Cookbook(int bookId, String bookName, String bookDesc, String authorId) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookDesc = bookDesc;
		this.authorId = authorId;
	}

	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookDesc() {
		return bookDesc;
	}
	public void setBookDesc(String bookDesc) {
		this.bookDesc = bookDesc;
	}
	public String getAuthorId() {
		return authorId;
	}
	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}
	
	@Override
	public String toString() {
		String str = " [Cookbook] "+"id: "+bookId+" name: "+bookName+" Desc: "+bookDesc+" authorId: "+authorId;
		return str;
		
	}
	
	
}
