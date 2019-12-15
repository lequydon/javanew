package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.loaibean;
import bo.loaibo;

/**
 * Servlet implementation class loaiadmincontroller
 */
@WebServlet("/loaiadmincontroller")
public class loaiadmincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loaiadmincontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		loaibo loaibo =new loaibo();
		if(request.getParameter("mlchon")!=null)
		{
			try {
				//System.out.print(loaibo.chon(request.getParameter("mlchon")));
				request.setAttribute("chonloai", loaibo.chon(request.getParameter("mlchon")));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(request.getParameter("mlxoa")!=null) {
			try {
				loaibo.xoa(request.getParameter("mlxoa"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(request.getParameter("them")!=null) {
			try {
				loaibo.them(request.getParameter("maloai"),request.getParameter("tenloai"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(request.getParameter("sua")!=null) {
			try {
				loaibo.sua(request.getParameter("maloai"), request.getParameter("tenloai"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ArrayList<loaibean> listloai=loaibo.getloai();
		request.setAttribute("dsloai", listloai);
		RequestDispatcher rd=request.getRequestDispatcher("loaiAdmin.jsp");
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
