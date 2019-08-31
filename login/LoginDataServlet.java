package org.deepak.login;

import java.io.IOException;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/LoginDataServlet")
public class LoginDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name="jdbc/login-webapp")
	
	private DataSource datasource;
	LoginDb login;
	Verification ver = new Verification();
	
	
	@Override
	public void init() throws ServletException {
		super.init();
		try {
			login = new LoginDb(datasource);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String command = request.getParameter("command");
			switch(command) {
				case "login":
					getStudent(request, response);
					break;
				case "update":
					setStudent(request, response);
					break;
				case "thanks":
					response.sendRedirect("Login-form.jsp");
				case "check":
					checkpass(request,response);
					break;
				case "forgot":
					forgotpass(request,response);
				default:
				response.getWriter().print("Not Working");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void checkpass(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {
			String username = request.getParameter("username");
			if(login.check(username) && !(username.isEmpty())) {
				request.getSession().setAttribute("username", username);
				response.sendRedirect("Forgot-password.jsp");
				return;
			}
			if(username.isEmpty()){
				request.getSession().setAttribute("bool9", true);
				request.getSession().setAttribute("warning", "**Enter valid username**");
				response.sendRedirect("Check-username.jsp");
				return;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private void forgotpass(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
			String username = (String) request.getSession().getAttribute("username");
			String pass1 = request.getParameter("password1");
			String pass2 = request.getParameter("password2");
			if(pass1.equals(pass2) && !(pass1.isEmpty()) && !(pass2.isEmpty())) {
				login.update(pass1,username);
				request.getSession().setAttribute("bool8", true);
				request.getSession().setAttribute("message2", "!!Password updated successfully!!");
				response.sendRedirect("Forgot-password.jsp");
			}
			else if (!(pass1.equals(pass2))){
				request.getSession().setAttribute("bool7", true);
				request.getSession().setAttribute("warning1", "Password not matched");
				response.sendRedirect("Forgot-password.jsp");
			}
			else {
				request.getSession().setAttribute("bool6", true);
				request.getSession().setAttribute("warning2", "Enter valid password");
				response.sendRedirect("Forgot-password.jsp");
			}
	}

	private void getStudent(HttpServletRequest request, HttpServletResponse response) {
		try {
			String username = request.getParameter("username");
			String page= "";
			String password = request.getParameter("password");
			boolean logindata = login.getStudent(username, password);
			if(logindata == true) {
				page = "Thankyou.jsp";
			}
			else {
				String message = "**User not found**";
				request.getSession().setAttribute("message", message);
				request.getSession().setAttribute("bool5", "true");
				page = "Login-form.jsp";
			}
			response.sendRedirect(page);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void setStudent(HttpServletRequest request, HttpServletResponse response) {
	try {	
		boolean data1 = false;
		boolean data2 = false;
		boolean data3 = false;
		String username = request.getParameter("user");
		String password = request.getParameter("pass");
		String email = request.getParameter("email");
		if(username.isEmpty() ||ver.dataverify(username)) {
				data1 = true;
				request.getSession().setAttribute("bool1", data1);
				request.getSession().setAttribute("username","Enter valid username");
			}
			if(password.isEmpty()) {
				data2 = true;
				request.getSession().setAttribute("bool2", data2);
				request.getSession().setAttribute("password","Enter valid password");
			}
			if(email.isEmpty() || ver.emailverify(email)) {
				data3 = true;
				request.getSession().setAttribute("bool3", data3);
				request.getSession().setAttribute("email","Enter valid email");
			}
			if(data1 == false && data2 == false && data3 == false) {
				login.setStudent(username, password, email);
				request.getSession().setAttribute("bool4", true);
				request.getSession().setAttribute("success", "!!User created succesfully!!");
				response.sendRedirect("Sign-Up-Form.jsp");
			}
			if(data1 == true || data2 == true || data3 == true) {
				response.sendRedirect("Sign-Up-Form.jsp");
			}
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
}
