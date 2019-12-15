package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Userbean;
import bo.Userbo;

/**
 * Servlet implementation class DangnhapController
 */
@WebServlet("/DangnhapController")
public class DangnhapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangnhapController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.print("test thử");
		if(request.getParameter("loginID")!=null){
			Userbo accountbo= new Userbo();
			Userbean accountinfo=new Userbean(request.getParameter("loginID"), request.getParameter("password"));
			String accountad=accountbo.getuserbo(accountinfo);
			System.out.print(accountad);
			if(accountad.equals("0"))
			{
				HttpSession session=request.getSession();
				session.removeAttribute("linkdatmua");
				session.setAttribute("loginID",request.getParameter("loginID"));
				session.setAttribute("password", request.getParameter("password"));
				response.sendRedirect("SachController");
			}
			if(accountad.equals("1"))
				response.sendRedirect("redirectadmin.jsp");
			
		}else
			response.sendRedirect("DangNhap.jsp");
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
