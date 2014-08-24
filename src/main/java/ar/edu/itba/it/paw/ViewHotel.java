package ar.edu.itba.it.paw;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.edu.itba.it.paw.model.Comment;
import ar.edu.itba.it.paw.model.CommentManager;
import ar.edu.itba.it.paw.model.Hotel;
import ar.edu.itba.it.paw.model.HotelManager;
import ar.edu.itba.it.paw.model.WebUtilities;
import ar.edu.itba.it.paw.view.CommentWebView;
import ar.edu.itba.it.paw.view.HotelTableView;

@SuppressWarnings("serial")
public class ViewHotel extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int requestedCode = Integer.valueOf(WebUtilities.getQueryMap(
				req.getQueryString()).get("code"));
		resp.getWriter().append(
				"<html><body>" +getHeaderHTMLCode()+ getHotelHTMLCode(requestedCode) + "</body></html>");

	}
	private String getHeaderHTMLCode(){
		return "<h1>Details for Hotel:</h1>";
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
	private String getCommentForHotelHTMLCode(Hotel requestedHotel){
		List<Comment> comments = CommentManager.getInstance().getComments(requestedHotel);
		StringBuffer sb = new StringBuffer();
		sb.append("Other users commented:<br/>");
		for(Comment c:comments){
			sb.append(CommentWebView.getView(c));
		}
		
		return sb.toString();
	}
}
