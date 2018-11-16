package projet.delegate;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

import projet.data.ReimburseImplement;
import projet.model.*;
import projet.service.*;

public class HomeDelegate {

public void goHome (HttpServletRequest request, HttpServletResponse response)
throws IOException	{

	HttpSession session = request.getSession();
	Employee login = (Employee) session.getAttribute("user");

	if (login==null) {response.sendRedirect("login");}
	else	{

PrintWriter pw = response.getWriter();



ArrayList<String> oHTML0 = listHTML("/home/raymundo/Destroy/Projet/src/main/webapp/static/hm00.txt");
for (int i=0; i<oHTML0.size(); i++){
pw.write(oHTML0.get(i));	}




if (login.getAdmin().equals("1"))
{pw.write(" <div> <a href=\"admin\">Administrator Page</a> </div> ");}

pw.write(" <div> <h3> Hello " + EmployeeService.getEmployeeService().getEmployeeInfo(login.getUsername()).getFirstname() + " </h3> </div>");
pw.write(" <p> <br> </p> ");

pw.write(" <div id=\"eClaimTable\" class = \"container\"> <table class=\"table table-hover\" width=\"85%\" > <caption>Profile Information</caption> ");
pw.write(" <tr> <th>UserName</th> <th>PassWord</th> <th>FirstName</th> <th>LastName</th> <th>Admin</th> <th>E-Mail</th> </tr> ");
pw.write(login.toString());
pw.write(" </table> </div> ");


//String usnm = EmployeeService.getEmployeeService().getEmployeeInfo(login.getUsername()).getUsername().trim();
//pw.write(usnm);


pw.write(" <hr> <div> <table width=\"85%\" > <caption>Claim List</caption> ");
pw.write(" <tr> <th>ClaimID</th> <th>Amount</th> <th>Description</th> <th>Status</th> <th>Transaction Date</th> <th>Judgement Date</th> <th>UserName</th> </tr> ");
for (int j=0; j<EmployeeService.getEmployeeService().listClaims(login.getUsername()).size(); j++) {
	pw.write(EmployeeService.getEmployeeService().listClaims(login.getUsername()).get(j).toString());
}
pw.write(" </table> </div> ");




BufferedReader in01 = new BufferedReader(new FileReader("/home/raymundo/Destroy/Projet/src/main/webapp/static/InitClaim.txt") );
String inHTML;
inHTML = in01.readLine();
while(inHTML != null) {
	pw.write(inHTML + "\n");
	inHTML = in01.readLine();
		}
in01.close();





ArrayList<String> oh08 = listHTML("/home/raymundo/Destroy/Projet/src/main/webapp/static/NewEmail.txt");
for (int i=0; i<oh08.size(); i++){
pw.write(oh08.get(i));	}




ArrayList<String> oHTML10 = listHTML("/home/raymundo/Destroy/Projet/src/main/webapp/static/hm10.txt");
for (int i=0; i<oHTML10.size(); i++){	pw.write(oHTML10.get(i));	}




}


}








public void beginClaim (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session = request.getSession();
	Employee login = (Employee) session.getAttribute("user");
	
	String descript = request.getParameter("descript");
	double amt		= Double.parseDouble(request.getParameter("amount"));
	
	ReimburseImplement.getReimburseDao().startClaim(login.getUsername(), descript, amt);
	
	response.sendRedirect("home");
}


public void changeEmail (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String usernme		= request.getParameter("usernme");
	String passwrd		= request.getParameter("passwrd");
	String newEmail	= request.getParameter("nmail");

	EmployeeService.getEmployeeService().changeEmail(usernme, passwrd, newEmail);

	response.sendRedirect("home");
}
















public ArrayList<String> listHTML (String inputPath) throws IOException {
	ArrayList <String> outHTML = new ArrayList <String> ();
	BufferedReader in = new BufferedReader (new FileReader(inputPath) );
	String inHTML = in.readLine();
	while(inHTML != null) {
		outHTML.add(inHTML + "\n");
		inHTML = in.readLine();
			}
	in.close();
return outHTML;
}







}