package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TestController
 */
@WebServlet("/TestController")
public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */	
    public TestController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    if(request.getParameter("but1")!=null) {
	    	long kq=0,a=0,b=0;
			String nut=request.getParameter("but1");
			String aa=request.getParameter("txta");
			String bb=request.getParameter("txtb");
		if(aa!=null&&bb!=null&&nut!=null){
			System.out.print("ok");
			a= Long.parseLong(aa);
			 b= Long.parseLong(bb);
			if(nut.equals("+")) kq=a+b;
			if(nut.equals("-")) kq=a-b;
			if(nut.equals("*")) kq=a*b;
			if(nut.equals("/"))	kq=a/b;
			HttpSession sesstion=request.getSession();
			sesstion.setAttribute("kq", kq);
			response.sendRedirect("maytinhcontroller.jsp");
		}
		
	}
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
