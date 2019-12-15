package bo;
import java.util.ArrayList;

import bean.sachbean;
import bean.sachfullinfobean;
import dao.sachdao;
public class sachbo {
	sachdao s=new sachdao();
	ArrayList<sachbean> ds;
	public ArrayList<sachbean> getsach(){
		ds=s.getsach();
		return s.getsach();
	}
	public ArrayList<sachbean> getsach(String maloai){
		return s.getsach(maloai);
	}
	public ArrayList<sachbean> timsach(String maloai){
		ArrayList<sachbean>tam=new ArrayList<sachbean>();
		for(sachbean s: ds) {
			if(s.getMaloai().equals(maloai))
				tam.add(s);
		}
		return tam;
	}
	public ArrayList<sachbean> timkey(String key){
		key=key.toLowerCase();
		ArrayList<sachbean>tam=new ArrayList<sachbean>();
		for(sachbean s: ds) {
			if(s.getTensach().toLowerCase().contains(key))
				tam.add(s);
		}
		return tam;
	}
	public int xoa(String masach) throws Exception {
		return s.xoa(masach);
	}
	public int them(sachfullinfobean sach) throws Exception {
		return s.Them(sach);
	}
	public int sua(sachfullinfobean sach) throws Exception {
		return s.sua(sach);
	}
	public sachfullinfobean chon(String masach) throws Exception {
		return s.chon(masach);
	}
	public ArrayList<sachfullinfobean> getfullsach(){
		return s.getfullsach();
	}
}
