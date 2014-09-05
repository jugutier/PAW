package ar.edu.itba.it.paw;

import java.io.IOException;
import java.io.PrintWriter;
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
import ar.edu.itba.it.paw.view.CommentWebView;
import ar.edu.itba.it.paw.view.HotelTableView;

@SuppressWarnings("serial")
public class ViewHotel extends HttpServlet {
	private UserInfo userInfo;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int requestedCode = Integer.valueOf(req.getParameter("code"));
		PrintWriter out = resp.getWriter();
		out.append("<html><body>");
		out.append(getBackHTMLCode());
		out.append(getHeaderHTMLCode());
		HttpSession sess = req.getSession(false);
		if (sess != null) {
			userInfo = (UserInfo) sess.getAttribute("USER");
			out.append(getHotelHTMLCode(requestedCode));
		}
		out.append(getSubmitCommentHTMLCode(req.getContextPath(), requestedCode));
		out.append("</body></html>");

	}

	private String getHeaderHTMLCode() {
		return "<h1>Details for Hotel:</h1>";
	}

	private String getBackHTMLCode() {
		return "<a href=\"../listHotels\">back</a>";
	}

	private String getHotelHTMLCode(int requestedCode) {
		Hotel requestedHotel = HotelManager.getInstance().getHotelByCode(
				requestedCode);
		StringBuffer sb = new StringBuffer();
		sb.append("<table border=\"1\" style=\"width:300px\"> ");// TODO: style?
		sb.append(HotelTableView.getHeaderView());
		sb.append(HotelTableView.getDetailedView(requestedHotel));
		sb.append("</table>");
		sb.append(getCommentForHotelHTMLCode(requestedHotel));
		return sb.toString();
	}

	private String getCommentForHotelHTMLCode(Hotel requestedHotel) {
		List<Comment> comments = CommentManager.getInstance().getComments(
				requestedHotel);
		StringBuffer sb = new StringBuffer();
		if (comments.isEmpty()) {
			sb.append("<h2>No comments yet, be the first to comment!</h2>");
		} else {
			sb.append("<h2>Other users commented:</h2><br/>");
			for (Comment c : comments) {
				sb.append(CommentWebView.getView(c));
				sb.append("<hr width=\"300\" align=\"left\">");
			}
		}

		return sb.toString();
	}

	private String getSubmitCommentHTMLCode(String context, int requestedCode) {
		StringBuffer sb = new StringBuffer();
		sb.append("<h3>Submit a comment:</h3>");
		sb.append("<form method=\"POST\" action=\"/HotelApp/addComment/?code="
				+ requestedCode + "\">"); // TODO:why doesn't app context work
		sb.append("<strong>name:</strong> <label>"+userInfo.getName()+"</label><br/>");
		sb.append("<strong>name:</strong> <label>"+userInfo.getEmail()+"</label><br/>");
		sb.append("<strong>comment:</strong> <input style=\"width=300px;height=300px;\" name =\"text\" value=\"write a comment here\"><br/>");
		sb.append("<button type=\"submit\">Submit</button>");
		sb.append("</form>");
		return sb.toString();
	}
}
