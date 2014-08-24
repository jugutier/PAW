package ar.edu.itba.it.paw;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.edu.itba.it.paw.model.Comment;
import ar.edu.itba.it.paw.model.CommentManager;
import ar.edu.itba.it.paw.model.HotelManager;
import ar.edu.itba.it.paw.model.UserInfo;
import ar.edu.itba.it.paw.model.WebUtilities;

@SuppressWarnings("serial")
public class AddComment extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Map<String, String[]> map = req.getParameterMap();
		Comment c = new Comment(new UserInfo( map.get("userName")[0],map.get("email")[0]),map.get("text")[0]);
		int requestedCode = Integer.valueOf(WebUtilities.getQueryMap(
				req.getQueryString()).get("code"));
		CommentManager.getInstance().addComent(c, HotelManager.getInstance().getHotelByCode(requestedCode));
		resp.sendRedirect("/HotelApp/viewHotel/?code="+requestedCode);
	}
}
