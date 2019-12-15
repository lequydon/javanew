package Controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.*;

import bean.loaibean;
import bean.sachfullinfobean;
import bo.loaibo;
import bo.sachbo;

/**
 * Servlet implementation class sachadmincontroller
 */
@WebServlet("/sachadmincontroller")
public class sachadmincontroller extends HttpServlet {
	private boolean isMultipart;
	private String filePath;
	private int maxFileSize = 50 * 1024;
	private int maxMemSize = 4 * 1024;
	private File file;

	public void init() {
		// Get the file location where it would be stored.
		filePath = getServletContext().getInitParameter("file-upload");
	}

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public sachadmincontroller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		loaibo loaibo = new loaibo();
		sachbo sachbo = new sachbo();
		if(request.getParameter("masachchon")!=null) {
			sachfullinfobean sachchon;
			try {
				sachchon = sachbo.chon(request.getParameter("masachchon"));
				request.setAttribute("sachchon",sachchon );
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(request.getParameter("masachxoa")!=null) {
			try {
				sachbo.xoa(request.getParameter("masachxoa"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (request.getParameter("sua") != null) {
			long gias=Long.parseLong(request.getParameter("gia"));
			 int sotaps=Integer.parseInt(request.getParameter("sotap"));
			 int soluongs=Integer.parseInt(request.getParameter("soluong"));
			 String masachs=request.getParameter("masach").toString();
			 String tensachs=request.getParameter("tensach").toString();
			 String tacgias=request.getParameter("tacgia").toString();
			 String maloais=request.getParameter("loai");
			 System.out.print(request.getParameter("ngaynhap"));
			 try {
				 Date ngaynhaps=new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("ngaynhap"));
				 sachfullinfobean sach=new sachfullinfobean(masachs, tensachs, tacgias, gias, "", ngaynhaps, maloais, soluongs, sotaps);
					sachbo.sua(sach);
			 } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 }
		}
		if (request.getParameter("them") != null) {
			 long gia=Long.parseLong(request.getParameter("gia"));
			 int sotap=Integer.parseInt(request.getParameter("sotap"));
			 int soluong=Integer.parseInt(request.getParameter("soluong"));
			 String masach=request.getParameter("masach").toString();
			 String tensach=request.getParameter("tensach").toString();
			 String tacgia=request.getParameter("tacgia").toString();
			 String maloai=request.getParameter("loai");
			 System.out.print(request.getParameter("ngaynhap"));
			 try {
				 Date ngaynhap=new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("ngaynhap"));
				 sachfullinfobean sach=new sachfullinfobean(masach, tensach, tacgia, gia, "", ngaynhap, maloai, soluong, sotap);
					sachbo.them(sach);
			 } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 // upload file
			/*
			 * try { Part filePart = request.getPart("image"); // Retrieves <input
			 * type="file" name="file"> String fileName =
			 * Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE
			 * fix. InputStream fileContent = filePart.getInputStream(); File filepath = new
			 * File("D:\\JavaNangcao\\Sach\\WebContent\\image_sach");
			 * Files.copy(fileContent, filepath.toPath()); System.out.print("ok");
			 * }catch(Exception e) { System.out.print(e); }
			 */
			// Check that we have a file upload request

		}
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		ArrayList<loaibean> listloai = loaibo.getloai();
		ArrayList<sachfullinfobean> listsach = sachbo.getfullsach();
		request.setAttribute("dssach", listsach);
		request.setAttribute("dsloai", listloai);
		RequestDispatcher rd = request.getRequestDispatcher("SachAdminpage.jsp");
		rd.forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
