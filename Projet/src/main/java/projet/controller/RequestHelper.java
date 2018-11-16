package projet.controller;

import java.io.IOException;
import javax.servlet.http.*;
import javax.servlet.ServletException;

import projet.delegate.*;

public class RequestHelper {
	private AdminDelegate adminDel = new AdminDelegate();
private HomeDelegate homeDel = new HomeDelegate();
private LoginDelegate loginDel = new LoginDelegate();

public void process (HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

String switchString = request.getRequestURI().substring(
	request.getContextPath().length()+1);

while (switchString.indexOf("/")>0) {
	switchString = switchString.substring(0, switchString.indexOf("/"));	}

switch(switchString) {
	case "home":	homeDel.goHome(request, response);	break;
	case "admin":	adminDel.goToAdminPage(request, response);	break;
	case "login":	if("POST".equalsIgnoreCase(request.getMethod())) {
			loginDel.login(request, response);	}
			else {	loginDel.getPage(request, response);	}
			break;
	case "claim":	if ("POST".equalsIgnoreCase(request.getMethod())) {homeDel.beginClaim(request, response);} break;
	case "logout":	loginDel.logout(request, response);			break;
	case "newMail":	homeDel.changeEmail(request, response);		break;
	case "approve":	adminDel.approveR(request, response);		break;
	case "reject":	adminDel.rejectClaim(request, response);	break;
	case "register": adminDel.regEmploy(request, response);		break;
	default:	loginDel.getPage(request, response);			break;	}

}

}
