package bo;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import bean.giohangbean;

public class giohanhbo {
	public ArrayList<giohangbean> ds= new ArrayList<giohangbean>();
	public void Add(String masach, String tensach, String tacgia,long gia, long soluong) {
		ds.add(new giohangbean(masach, tensach, tacgia, gia, soluong));
		ArrayList<giohangbean> dsgh= new ArrayList<giohangbean>();
		int flagTheFirst=0;
		for(giohangbean dsgio: ds) {
			if(flagTheFirst==0) {
				dsgh.add(dsgio);
				flagTheFirst=1;
			}
			else {
					int flagTheFirstFind=0;
					for(giohangbean dsghtemp: dsgh) {
						if(dsghtemp.getMasach().equals(dsgio.getMasach())) {
							flagTheFirstFind=1;
							dsghtemp.setSoluong(dsghtemp.getSoluong()+1);
							dsghtemp.setThanhtien(dsghtemp.getGia()*dsghtemp.getSoluong());
						}
					}
					if(flagTheFirstFind==0)
						dsgh.add(dsgio);
			}
		}
		ds=dsgh;
	}
	public Long Sum() {
		
		long s=0;
		for(giohangbean sach: ds)
			s+=sach.getThanhtien();
		return s;
	}
	public int Count() {
		
			return ds.size();
	}
	public ArrayList<giohangbean> GetListgiohang( ArrayList<giohangbean> gh) {
		ArrayList<giohangbean> dsgh= new ArrayList<giohangbean>();
		return dsgh;
	}
}
