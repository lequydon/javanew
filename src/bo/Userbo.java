package bo;

import bean.Userbean;
import dao.Userdao;

public class Userbo {
	public Userbean getuserbo() {
		Userdao getuserdao=new Userdao();
		return getuserdao.getUserdao();
	}
}
