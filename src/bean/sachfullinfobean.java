package bean;

import java.util.Date;

public class sachfullinfobean {
	private String masach;
	private String tensach;
	private String tacgia;
	private long gia;
	private String anh;
	private Date ngaynhap;
	private String maloai;
	private int soluong;
	private int sotap;
	
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

	public String getTacgia() {
		return tacgia;
	}

	public void setTacgia(String tacgia) {
		this.tacgia = tacgia;
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

	public Date getNgaynhap() {
		return ngaynhap;
	}

	public void setNgaynhap(Date ngaynhap) {
		this.ngaynhap = ngaynhap;
	}

	public String getMaloai() {
		return maloai;
	}

	public void setMaloai(String maloai) {
		this.maloai = maloai;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public int getSotap() {
		return sotap;
	}

	public void setSotap(int sotap) {
		this.sotap = sotap;
	}
	public sachfullinfobean() {
		this.masach = "";
		this.tensach ="";
		this.tacgia = "";
		this.gia = 0;
		this.anh = "";
		this.ngaynhap = new Date();
		this.maloai = "";
		this.soluong = 0;
		this.sotap = 0;
	};
	public sachfullinfobean(String masach, String tensach, String tacgia, long gia, String anh, Date ngaynhap,
			String maloai, int soluong, int sotap) {
		super();
		this.masach = masach;
		this.tensach = tensach;
		this.tacgia = tacgia;
		this.gia = gia;
		this.anh = anh;
		this.ngaynhap = ngaynhap;
		this.maloai = maloai;
		this.soluong = soluong;
		this.sotap = sotap;
	}
	
}
