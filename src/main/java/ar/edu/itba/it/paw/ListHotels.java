package ar.edu.itba.it.paw;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.edu.itba.it.paw.model.Hotel;
import ar.edu.itba.it.paw.model.HotelManager;
import ar.edu.itba.it.paw.view.HotelTableView;

@SuppressWarnings("serial")
public class ListHotels extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		List<Hotel> hotels = HotelManager.getInstance().getHotels();
		StringBuffer sb= new StringBuffer();
		sb.append("<table border=\"1\" style=\"width:300px\"> ");//TODO: style?
		sb.append(HotelTableView.getHeaderView());
		for (Hotel hotel : hotels) {
			sb.append(HotelTableView.getTableView(hotel));
		}
		sb.append("</table>");
	resp.getWriter().append("<html><body>" + sb.toString()+
	"</body></html>");
	}
}
