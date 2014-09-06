package ar.edu.itba.it.paw;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ar.edu.itba.it.paw.model.CredentialsManager;
import ar.edu.itba.it.paw.model.UserInfo;

@SuppressWarnings("serial")
public class Login extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("GET");
		PrintWriter out = resp.getWriter();
		out.println("<head><body>");
		out.println("<h1>Hotel app!</h1>");
		String login = req.getParameter("error");
		if (login != null && login.equals("true")) {
			out.println("<span><font color=\"red\">Error try again</font></span><br/>");
		}
		out.println("<span>Sign in to access</span><br/>");
		out.println("<form method=\"POST\" action=\"" + req.getContextPath()
				+ "/login\">");
		out.println("<strong><label for=\"username\">Username:</label></strong>");
		out.println("<input type=\"username\" value=\"john doe\" name=\"username\"><br/>");
		out.println("<strong><label for=\"password\">Password:</label></strong>");
		out.println("<input type=\"password\" value=\"\" name=\"password\"><br/>");
		out.println("<input type=\"submit\" name=\"login\" value=\"Log In\">");
		out.println("</form>");
		out.println("</head></body>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		if (CredentialsManager.getInstance().isValid(username, password)) {
			HttpSession sess = req.getSession(true);
			UserInfo userInfo = new UserInfo(username, "a@a.com");
			sess.setAttribute("USER", userInfo);
			resp.sendRedirect(req.getContextPath() + "/listHotels");
		} else {
			resp.sendRedirect(req.getContextPath() + "/login?error=true");
		}

	}
}
