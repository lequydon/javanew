package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import bean.sachbean;
public class sachdao {
	public ArrayList<sachbean> getsach(){
		ArrayList<sachbean> ds= new ArrayList<sachbean>();
		try {
			DungChung dst=new DungChung();
			dst.KetNoi();
			String sql="select * from sach";
			PreparedStatement cmd=dst.cn.prepareStatement(sql);
			ResultSet rs=cmd.executeQuery();//thuc hien câu lenh truy van
			while(rs.next()) {
				String masach=rs.getString("masach");
				String tensach=rs.getString("tensach");
				String tacgia=rs.getString("tacgia");
				long gia=rs.getLong("gia");
				String anh=rs.getString("anh");
				Date ngaynhap=rs.getDate("NgayNhap");
				String maloai=rs.getString("maloai");
				sachbean s= new sachbean(masach, tensach, tacgia, gia, anh, ngaynhap,maloai);
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
	public ArrayList<sachbean> getsach(String maloai1){
		ArrayList<sachbean> ds= new ArrayList<sachbean>();
		try {
			DungChung dst=new DungChung();
			dst.KetNoi();
			String sql="select * from sach where sach.maloai="+maloai1+"";
			PreparedStatement cmd=dst.cn.prepareStatement(sql);
			ResultSet rs=cmd.executeQuery();//thuc hien câu lenh truy van
			while(rs.next()) {
				String masach=rs.getString("masach");
				String tensach=rs.getString("tensach");
				String tacgia=rs.getString("tacgia");
				long gia=rs.getLong("gia");
				String anh=rs.getString("anh");
				Date ngaynhap=rs.getDate("NgayNhap");
				String maloai=rs.getString("maloai");
				sachbean s= new sachbean(masach, tensach, tacgia, gia, anh, ngaynhap,maloai);
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
