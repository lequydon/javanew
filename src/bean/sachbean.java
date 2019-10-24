package bean;

public class sachbean {
	private String masach;
	private String tensach;
	private long gia;
	private String anh;
	
	public sachbean(String masach, String tensach, long gia, String anh) {
		super();
		this.masach = masach;
		this.tensach = tensach;
		this.gia = gia;
		this.anh = anh;
	}
	public String getMasach() {
		return masach;
	}
	public void setMasach(String masach) {
		this.masach = masach;
	}
	public String getTensach() {
		return tensach;
	}
	public void setTensach(String tensach) {
		this.tensach = tensach;
	}
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	
}