package ar.edu.itba.it.paw;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ar.edu.itba.it.paw.model.Comment;
import ar.edu.itba.it.paw.model.CommentManager;
import ar.edu.itba.it.paw.model.HotelManager;
import ar.edu.itba.it.paw.model.UserInfo;

@SuppressWarnings("serial")
public class AddComment extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession sess = req.getSession(false);
		if (sess == null) {
			throw new IllegalStateException();
		}
		UserInfo userInfo = (UserInfo) sess.getAttribute("USER");
		Comment c = new Comment(userInfo, req.getParameter("text"));
		int requestedCode = Integer.valueOf(req.getParameter("code"));
		CommentManager.getInstance().addComent(c,
				HotelManager.getInstance().getHotelByCode(requestedCode));

		resp.sendRedirect("viewHotel?code=" + requestedCode);
	}
}
