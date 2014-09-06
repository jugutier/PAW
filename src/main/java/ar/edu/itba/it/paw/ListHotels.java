package ar.edu.itba.it.paw;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ar.edu.itba.it.paw.model.Hotel;
import ar.edu.itba.it.paw.model.HotelManager;
import ar.edu.itba.it.paw.view.HotelTableView;

@SuppressWarnings("serial")
public class ListHotels extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Hotel> hotels = HotelManager.getInstance().getHotels();
		StringBuffer sb = new StringBuffer();
		sb.append(getLogoutHTMLCode());
		sb.append("<br/>");
		sb.append("<br/>");
		sb.append("<table border=\"1\" style=\"width:300px\"> ");// TODO: style?
		sb.append(HotelTableView.getHeaderView());
		for (Hotel hotel : hotels) {
			sb.append(HotelTableView.getTableView(hotel));
		}
		sb.append("</table>");
		resp.getWriter().append(
				"<html><body>" + sb.toString() + "</body></html>");
	}

	private String getLogoutHTMLCode() {
		StringBuffer sb = new StringBuffer();
		sb.append("<form method=\"POST\" action=\"listHotels\">");//TODO:fix path?
		sb.append("<button type=\"submit\">Log out</button>");
		sb.append("</form>");
		return sb.toString();
		//return "<a href=\"/\">Log out</a>";
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//if (req.getParameter("logout") != null) {
		System.out.println("DOPOST");
		System.out.flush();;
			HttpSession sess = req.getSession(false);
			if (sess != null) {
				System.out.println("invalidate");
				sess.invalidate();
			}
			resp.sendRedirect("./");
		//}
	}
}
