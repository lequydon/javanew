package bo;

import java.util.ArrayList;

import bean.loaibean;
import bean.sachbean;
import dao.loaidao;
import dao.sachdao;
public class loaibo {
	loaidao s=new loaidao();
	public ArrayList<loaibean> getloai(){
		return s.getloai();
	}
	public int sua(String maloai,String tenloaimoi) throws Exception {
		return s.sua(maloai, tenloaimoi);
	}
	public int them(String maloai,String tenloai) throws Exception {
		return s.Them(maloai, tenloai);
	}
	public int xoa(String maloai) throws Exception {
		return s.xoa(maloai);
	}
	public loaibean chon(String maloai) throws Exception {
		return s.chon(maloai);
	}
}
