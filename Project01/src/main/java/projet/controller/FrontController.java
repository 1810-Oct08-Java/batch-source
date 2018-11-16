package projet.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import org.apache.catalina.servlets.DefaultServlet;



public class FrontController extends DefaultServlet {

private static final long serialVersionUID = 1L;

private RequestHelper rh = new RequestHelper();

@Override
protected void doGet (HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

	if (request.getRequestURI().substring(request.getContextPath().length()).startsWith
		("/static/")) {	super.doGet(request, response);
	}	else	{	rh.process(request, response);	}

}








@Override
protected void doPost (HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		doGet(request, response);
}

}
