package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.loaibean;
import bean.sachbean;
import bo.loaibo;
import bo.sachbo;

/**
 * Servlet implementation class SachController
 */
@WebServlet("/SachController")
public class SachController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SachController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
 sachbo sbo= new sachbo();
 loaibo lbo=new loaibo();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//đảm bảo trả về tiếng việt
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		//tìm kiếm
		String tk=request.getParameter("search");
		//get loai
		ArrayList<loaibean> loai=lbo.getloai();
		request.setAttribute("loai", loai);
		//get sach
		String ml=request.getParameter("maloai");
		ArrayList<sachbean> ds = null;
		if(tk!=null||ml!=null) {
			if(tk!=null) {
				ds=sbo.timkey(tk);
			}
			System.out.print(ds);
			if(ml!=null)
			{
				
				ds=sbo.timsach(ml);
			}
		}
		else
			ds=sbo.getsach();
		request.setAttribute("ds", ds);
		RequestDispatcher rd=request.getRequestDispatcher("htsach.jsp");
		rd.forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
