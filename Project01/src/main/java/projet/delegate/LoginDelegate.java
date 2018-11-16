package projet.delegate;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import projet.model.*;
import projet.data.*;
import projet.service.*;

public class LoginDelegate {

public LoginDao ldao = new LoginDB();

//public ReimburseDao rdao = new ReimburseImplement();


public void login (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

String username = request.getParameter("user");
String password = request.getParameter("pass");

Employee login = EmployeeService.getEmployeeService().getEmployee(username, password);

if (login==null) {
	response.sendRedirect("login");
}	else	{
	HttpSession session = request.getSession();
	session.setAttribute("user", login);
	response.sendRedirect("home");	}
}



public void getPage (HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException	{
	HttpSession session = request.getSession();

if (session.getAttribute("user")==null) {
	request.getRequestDispatcher("static/login.html").forward(request, response);
}	else	{
response.sendRedirect("home");	}


}


public void logout (HttpServletRequest request, HttpServletResponse response) throws IOException {
	request.getSession().invalidate();
	response.sendRedirect("login");
}

}
