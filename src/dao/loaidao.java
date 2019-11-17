package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.loaibean;
import bean.sachbean;

public class loaidao {
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
