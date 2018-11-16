package test.tomcat.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletOutputStream;


import com.fasterxml.jackson.databind.ObjectMapper;

import data.session;

/**
 * Servlet implementation class DISPLAYALL
 */
public class DISPLAYALL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DISPLAYALL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session temp = new session();
		String SQL = "Select empid from activeuser";
		int empid = temp.initActive(SQL);
		SQL = "Select * from employee where empid = " + empid;
		SQL = temp.getQuery(SQL);
	
		/*
		response.setContentType("text/plain;charset=UTF-8");
        ServletOutputStream sout = response.getOutputStream();
        sout.print(SQL)
        */
		/*
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        out.print(SQL);
		*/

		response.getWriter().print(SQL);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
