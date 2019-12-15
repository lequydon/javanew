package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;


import bean.loaibean;
import bean.sachbean;
import bean.sachfullinfobean;
public class sachdao {
	public boolean kiemtra(String masach) throws Exception {
		dc.KetNoi();
		String sql="select * from sach where masach=?";
		PreparedStatement cmd=dc.cn.prepareStatement(sql);
		cmd.setString(1, masach);
		ResultSet rs=cmd.executeQuery();
		boolean kq=rs.next();
		cmd.close();
		return kq;
	}
	public int xoa(String masach) throws Exception {
		// neu loai ko co sach thi xoa
		dc.KetNoi();
		//thiet lap cau lenh sql de xoa
		//thuc hien cau lenh
		String sql="delete from sach where masach=?";
		PreparedStatement cmd=dc.cn.prepareStatement(sql);
		cmd.setString(1, masach);
		int kq=cmd.executeUpdate();
		dc.cn.close();
		return kq;
	}
	DungChung dc=new DungChung();
	
	public int Them(sachfullinfobean sach) throws Exception {
		DungChung dc=new DungChung();
		dc.KetNoi();
		//nếu trung ma thi ko them
		if(kiemtra(sach.getMasach())) return 0;
		//thiet lập câu lệnh sql
		String sql="insert into sach(masach,tensach,soluong,gia,maloai,sotap,anh,NgayNhap,tacgia) values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement cmd=dc.cn.prepareStatement(sql);
		cmd.setString(1, sach.getMasach());
		cmd.setString(2, sach.getTensach());
		cmd.setInt(3, sach.getSoluong());
		cmd.setLong(4, sach.getGia());
		cmd.setString(5, sach.getMaloai());
		cmd.setInt(6, sach.getSotap());
		cmd.setString(7, sach.getAnh());
		//cmd.setDate(8, new Date());
		cmd.setDate(8, new java.sql.Date(sach.getNgaynhap().getTime()));
		cmd.setString(9, sach.getTacgia());
		int ketqua=cmd.executeUpdate();
		// cho thực hiện
		dc.cn.close();
		return ketqua;
	}
	public sachfullinfobean chon(String masach) throws Exception {
		sachfullinfobean sachbean=null;
		try {
			dc.KetNoi();
			String sql="select * from sach where masach=?";
			PreparedStatement cmd=dc.cn.prepareStatement(sql);
			cmd.setString(1, masach);
			ResultSet rs=cmd.executeQuery();//thuc hien câu lenh truy van
			while(rs.next()) {
				String masach1=rs.getString("masach");
				String tensach=rs.getString("tensach");
				int soluong=rs.getInt("soluong");
				long gia=rs.getLong("gia");
				String maloai=rs.getString("maloai");
				int sotap=rs.getInt("sotap");
				String anh=rs.getString("anh");
				Date NgayNhap=rs.getDate("NgayNhap");
				String tacgia=rs.getString("tacgia");
				sachfullinfobean s= new sachfullinfobean(masach1, tensach, tacgia, gia, anh, NgayNhap, maloai, soluong, sotap);
				sachbean=s;
			}
			dc.cn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sachbean;
	}
	public int sua(sachfullinfobean sach) throws Exception {
		dc.KetNoi();
		//nếu trung ma thi ko them
			String sql="update sach set tensach=?,soluong=?,gia=?,maloai=?,sotap=?,anh=?,NgayNhap=?,tacgia=? where masach=?";
			PreparedStatement cmd=dc.cn.prepareStatement(sql);
			cmd.setString(1, sach.getTensach());
			cmd.setInt(2, sach.getSoluong());
			cmd.setLong(3, sach.getGia());
			cmd.setString(4, sach.getMaloai());
			cmd.setInt(5, sach.getSotap());
			cmd.setString(6, sach.getAnh());
			cmd.setDate(7,  new java.sql.Date(sach.getNgaynhap().getTime()));
			cmd.setString(8, sach.getTacgia());
			cmd.setString(9, sach.getMasach());
			int ketqua=cmd.executeUpdate();
			// cho thực hiện
			dc.cn.close();
			return ketqua;
		//thiet lập câu lệnh sql
		
	}
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
	public ArrayList<sachfullinfobean> getfullsach(){
		ArrayList<sachfullinfobean> ds= new ArrayList<sachfullinfobean>();
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
				int soluong=rs.getInt("soluong");
				int sotap=rs.getInt("sotap");
				sachfullinfobean s= new sachfullinfobean(masach, tensach, tacgia, gia, anh, ngaynhap, maloai, soluong, sotap);
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
