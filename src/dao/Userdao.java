package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.Userbean;
import bean.loaibean;
import bean.sachbean;

public class Userdao {
	public Userbean getUserdao() {
		Userbean getUser=new Userbean("donle2044@gmail.com","123");
		return getUser;
	}
	public String dangnhap(Userbean info){
		String quyen = null;
		try {
			DungChung dst=new DungChung();
			dst.KetNoi();
			String sql="select * from DangNhap where TenDangNhap=? and MatKhau=?";
			PreparedStatement cmd=dst.cn.prepareStatement(sql);
			cmd.setString(1,info.getEmail());
			cmd.setString(2,info.getPassword());
			ResultSet rs=cmd.executeQuery();//thuc hien câu lenh truy van
			while(rs.next()) {
				quyen=rs.getString("Quyen");
			}
			dst.cn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return quyen;
	}
}
