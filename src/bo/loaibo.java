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
}
