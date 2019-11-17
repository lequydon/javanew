package dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class DungChung {
	public Connection cn;
	public void KetNoi()throws Exception{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url="jdbc:sqlserver://localhost:1433;databaseName=QlSach;user=sa; password=123";
		cn=DriverManager.getConnection(url);
		System.out.print("dã kết noi");
	}
}
