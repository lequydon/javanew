package bo;

import bean.Userbean;
import dao.Userdao;

public class Userbo {
	public String getuserbo(Userbean info) {
		Userdao getuserdao=new Userdao();
		return getuserdao.dangnhap(info);
	}
}
