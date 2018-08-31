package constant;

public class Defines {
	// định nghĩa các thông số cho ứng dụng web
	private String urlPublic;
	private String urlAdmin;
	public static final String success = "Xử lý thành công";
	public static final String error = "Có lỗi. Vui lòng thử lại sau";
	public static final int row_count = 10;
	public static final int row_count_public = 4;
	public static final int row_count_cat = 6;
	public static final String DIR_UPLOAD = "files";
	public static final String email = "teststackjava@gmail.com";
	
	public String getUrlPublic() {
		return urlPublic;
	}
	public void setUrlPublic(String urlPublic) {
		this.urlPublic = urlPublic;
	}
	public String getUrlAdmin() {
		return urlAdmin;
	}
	public void setUrlAdmin(String urlAdmin) {
		this.urlAdmin = urlAdmin;
	}
	public static String getSuccess() {
		return success;
	}
	public static String getError() {
		return error;
	}
	public static int getRowCount() {
		return row_count;
	}
	
	
}
