package namoo.common.web;

/**
 * 여러개의 요청파라메터들을 포장하기 위한 JavaBean
 * @author 김기정
 */
public class Params {
	private String searchType;   /** 검색 유형 */
	private String searchValue;  /** 검색 값 */
	private int pageSize;        /** 페이지에 보여지는 목록 개수 */
	private int pageCount;       /** 페이지에 보여지는 페이지 개수 */
	private int requestPage;     /** 사용자 요청 페이지 */
	
	public Params() {
		this("", "", 10, 5, 1);
	}
	
	public Params(String searchType, String searchValue, int pageSize, int pageCount, int requestPage) {
		this.searchType = searchType;
		this.searchValue = searchValue;
		this.pageSize = pageSize;
		this.pageCount = pageCount;
		this.requestPage = requestPage;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getSearchValue() {
		return searchValue;
	}
	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getRequestPage() {
		return requestPage;
	}
	public void setRequestPage(int requestPage) {
		this.requestPage = requestPage;
	}
	@Override
	public String toString() {
		return "Params [searchType=" + searchType + ", searchValue=" + searchValue + ", pageSize=" + pageSize
				+ ", pageCount=" + pageCount + ", requestPage=" + requestPage + "]";
	}
	
}
