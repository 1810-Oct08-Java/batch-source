package test.tomcat.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.session;

/**
 * Servlet implementation class displaypending
 */
public class Displaypending extends HttpServlet {
	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 4373363200996081621L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public Displaypending() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session temp = new session();
		String SQL = "Select empid from activeuser";
		int empid = temp.initActive(SQL);
		System.out.println(empid);
		SQL = "Select * from reimburse where userid = " + empid;
		SQL = temp.getQueryR(SQL);
		SQL = "Current reimbursments \n" + SQL;
		response.getWriter().print(SQL);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
