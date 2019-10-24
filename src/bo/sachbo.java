package bo;
import java.util.ArrayList;

import bean.sachbean;
import dao.sachdao;
public class sachbo {
	sachdao s=new sachdao();
	public ArrayList<sachbean> getsach(){
		return s.getsach();
	}
}
