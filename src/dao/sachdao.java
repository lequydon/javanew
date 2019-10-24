package dao;
import java.util.ArrayList;

import bean.sachbean;
public class sachdao {
	public ArrayList<sachbean> getsach(){
		ArrayList<sachbean> ds= new ArrayList<sachbean>();
ds.add(new sachbean("s1", "java co ban 1", (long)50000,"b1.jpg"));
ds.add(new sachbean("s2", "java co ban 2", (long)50000,"b2.jpg"));
ds.add(new sachbean("s3", "java co ban 3", (long)50000,"b3.jpg"));
ds.add(new sachbean("s4", "java co ban 4", (long)50000,"b4.jpg"));
ds.add(new sachbean("s5", "java co ban 5", (long)50000,"b5.jpg"));
return ds;
	}
}
