package ar.edu.itba.it.paw;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.edu.itba.it.paw.model.Hotel;
import ar.edu.itba.it.paw.model.HotelGenerator;
import ar.edu.itba.it.paw.view.HotelView;

public class ListHotels extends HttpServlet{
	List<Hotel> hotels;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		hotels = HotelGenerator.generate();
		StringBuffer sb= new StringBuffer();
		
		for (Hotel hotel : hotels) {
			sb.append(HotelView.getView(hotel));
		}
	resp.getWriter().append("<html><body>" + sb.toString()+
	"</body></html>");
	}
}
