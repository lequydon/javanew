package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import bean.loaibean;
import bean.sachbean;

public class loaidao {
	//ktr xem có maloai trong bang loai ko
	public boolean kiemtra(String maloai) throws Exception {
		dc.KetNoi();
		String sql="select * from loai where maloai=?";
		PreparedStatement cmd=dc.cn.prepareStatement(sql);
		cmd.setString(1, maloai);
		ResultSet rs=cmd.executeQuery();
		boolean kq=rs.next();
		cmd.close();
		return kq;
	}
	public int xoa(String maloai) throws Exception {
		// neu loai ko co sach thi xoa
		dc.KetNoi();
		if(kiemtrasach(maloai))return 0;
		//thiet lap cau lenh sql de xoa
		//thuc hien cau lenh
		String sql="delete from loai where maloai=?";
		PreparedStatement cmd=dc.cn.prepareStatement(sql);
		cmd.setString(1, maloai);
		int kq=cmd.executeUpdate();
		dc.cn.close();
		return kq;
	}
	DungChung dc=new DungChung();
	//ktra xem ma laoi nay co sach hay ko
	public boolean kiemtrasach(String loai) throws Exception {
		String sql="select maloai from sach where maloai=?";
		PreparedStatement cmd=dc.cn.prepareStatement(sql);
		cmd.setString(1, loai);
		ResultSet rs=cmd.executeQuery();
		boolean kq=rs.next();
		cmd.close();
		return kq;
		//thuc hien cau lenh
		//neu tim dk tra ve true
		//return true;
	}
	public int Them(String maloai,String tenloai) throws Exception {
		dc.KetNoi();
		//nếu trung ma thi ko them
		if(kiemtra(maloai)) return 0;
		//thiet lập câu lệnh sql
		String sql="insert into loai(maloai,tenloai) values(?,?)";
		PreparedStatement cmd=dc.cn.prepareStatement(sql);
		cmd.setString(1, maloai);
		cmd.setString(2, tenloai);
		int ketqua=cmd.executeUpdate();
		// cho thực hiện
		dc.cn.close();
		return ketqua;
	}
	public loaibean chon(String maloai) throws Exception {
		loaibean loaibean=null;
		try {
			dc.KetNoi();
			String sql="select * from loai where maloai=?";
			PreparedStatement cmd=dc.cn.prepareStatement(sql);
			cmd.setString(1, maloai);
			ResultSet rs=cmd.executeQuery();//thuc hien câu lenh truy van
			while(rs.next()) {
				String maloai1=rs.getString("maloai");
				String tenloai=rs.getString("tenloai");
				loaibean s= new loaibean(maloai1,tenloai);
				loaibean=s;
			}
			dc.cn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loaibean;
	}
	public int sua(String maloai,String tenloaimoi) throws Exception {
		dc.KetNoi();
		//nếu trung ma thi ko them
			String sql="update loai set tenloai=? where maloai=?";
			PreparedStatement cmd=dc.cn.prepareStatement(sql);
			cmd.setString(1,tenloaimoi );
			cmd.setString(2,maloai );
			int ketqua=cmd.executeUpdate();
			// cho thực hiện
			dc.cn.close();
			return ketqua;
		//thiet lập câu lệnh sql
		
	}
	public ArrayList<loaibean> getloai(){
		ArrayList<loaibean> ds= new ArrayList<loaibean>();
		try {
			DungChung dst=new DungChung();
			dst.KetNoi();
			String sql="select * from loai";
			PreparedStatement cmd=dst.cn.prepareStatement(sql);
			ResultSet rs=cmd.executeQuery();//thuc hien câu lenh truy van
			while(rs.next()) {
				String maloai=rs.getString("maloai");
				String tenloai=rs.getString("tenloai");
				loaibean s= new loaibean(maloai,tenloai);
				ds.add(s);
			}
			dst.cn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds;
		//b3: lấy dư lieu vè
		
/*ds.add(new sachbean("s1", "java co ban 1", (long)50000,"b1.jpg"));
ds.add(new sachbean("s2", "java co ban 2", (long)50000,"b2.jpg"));
ds.add(new sachbean("s3", "java co ban 3", (long)50000,"b3.jpg"));
ds.add(new sachbean("s4", "java co ban 4", (long)50000,"b4.jpg"));
ds.add(new sachbean("s5", "java co ban 5", (long)50000,"b5.jpg"));
return ds;*/
	}

	
}
