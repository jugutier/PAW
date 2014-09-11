package ar.edu.itba.it.paw;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ar.edu.itba.it.paw.model.Comment;
import ar.edu.itba.it.paw.model.CommentManager;
import ar.edu.itba.it.paw.model.Hotel;
import ar.edu.itba.it.paw.model.HotelManager;
import ar.edu.itba.it.paw.model.UserInfo;

@SuppressWarnings("serial")
public class ViewHotel extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int requestedCode = Integer.valueOf(req.getParameter("code"));
		Hotel requestedHotel = HotelManager.getInstance().getHotelByCode(
				requestedCode);
		List<Comment> comments = CommentManager.getInstance().getComments(
				requestedHotel);
		req.setAttribute("hotel", requestedHotel);
		req.setAttribute("comments", comments);

		HttpSession sess = req.getSession(false);
		UserInfo userInfo = null;
		if (sess != null) {
			userInfo = (UserInfo) sess.getAttribute("USER");
		}else{
			System.out.println("ERROR");
			return;
		}
		System.out.println(userInfo.getName());
		req.setAttribute("userinfo", userInfo);
		req.getRequestDispatcher("/WEB-INF/jsp/viewHotel.jsp").forward(req,
				resp);

	}
}
