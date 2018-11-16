package projet.delegate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import projet.data.ReimburseImplement;
import projet.model.Employee;
import projet.service.EmployeeService;

public class AdminDelegate {

public void goToAdminPage (HttpServletRequest request, HttpServletResponse response)
throws IOException {
	HttpSession session = request.getSession();
	Employee login = (Employee) session.getAttribute("user");

	if (login==null) {response.sendRedirect("login");}
	if (! login.getAdmin().equals("1")) {response.sendRedirect("login");}
	else	{PrintWriter pw = response.getWriter();

	ArrayList<String> o00HTML = lsHTML("/home/raymundo/Destroy/Projet/src/main/webapp/static/adm00.txt");
	for (int i=0; i<o00HTML.size(); i++){	pw.write(o00HTML.get(i));	}





	pw.write(" <div class = \"container\"> <table class=\"table table-hover\" width=\"85%\" > <caption>Employee List</caption> ");
	pw.write(" <tr> <th>UserName</th> <th>PassWord</th> <th>FirstName</th> <th>LastName</th> <th>Admin</th> <th>E-Mail</th> </tr> ");
	for(int i=0; i<EmployeeService.getEmployeeService().employees().size(); i++) {
		pw.write(EmployeeService.getEmployeeService().employees().get(i).toString());
	}
	pw.write(" </table> </div> <br><br><br><br><br><br>");





	pw.write(" <hr> <div class = \"container\" > <table class=\"table table-hover\" width=\"80%\" > <caption>Claim List</caption> ");
	pw.write(" <tr> <th>ClaimID</th> <th>Amount</th> <th>Description</th> <th>Status</th> <th>Transaction Date</th> <th>Judgement Date</th> <th>UserName</th> </tr> ");
	for (int j=0; j<EmployeeService.getEmployeeService().listAllClaim().size(); j++) {
		pw.write(EmployeeService.getEmployeeService().listAllClaim().get(j).toString());
	}
	pw.write(" </table> </div> ");










	ArrayList<String> oh01 = lsHTML("/home/raymundo/Destroy/Projet/src/main/webapp/static/Approve.txt");
	for (int i=0; i<oh01.size(); i++){	pw.write(oh01.get(i));	}

	ArrayList<String> oh05 = lsHTML("/home/raymundo/Destroy/Projet/src/main/webapp/static/Deny.txt");
	for (int i=0; i<oh05.size(); i++){	pw.write(oh05.get(i));	}

	ArrayList<String> oh07 = lsHTML("/home/raymundo/Destroy/Projet/src/main/webapp/static/RegEmploy.txt");
	for (int i=0; i<oh07.size(); i++){	pw.write(oh07.get(i));	}








	ArrayList<String> o15HTML = lsHTML("/home/raymundo/Destroy/Projet/src/main/webapp/static/adm15.txt");
	for (int i=0; i<o15HTML.size(); i++){	pw.write(o15HTML.get(i));	}


	}
}




ArrayList<String> lsHTML (String inputPath) throws IOException {
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










public void approveR (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int claimIN = Integer.parseInt(request.getParameter("appClaim"));
		ReimburseImplement.getReimburseDao().approveClaim(claimIN);
	}





public void rejectClaim (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int claimIN = Integer.parseInt(request.getParameter("rejClaim"));
		ReimburseImplement.getReimburseDao().rejectClaim(claimIN);
		response.sendRedirect("home");
	}




public void regEmploy(HttpServletRequest request, HttpServletResponse response) throws IOException {
	String username = request.getParameter("usr");
	String password = request.getParameter("pwd");
	String firstname = request.getParameter("fname");
	String lastname = request.getParameter("lname");
	EmployeeService.getEmployeeService().registerEmployee(username, password, firstname, lastname);
	response.sendRedirect("home");
}






}