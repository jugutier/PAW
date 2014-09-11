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

@SuppressWarnings("serial")
public class ListHotels extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Hotel> hotels = HotelManager.getInstance().getHotels();
		req.setAttribute("hotelList", hotels);
		req.getRequestDispatcher("/WEB-INF/jsp/listHotels.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("DOPOST");
		System.out.flush();
		HttpSession sess = req.getSession(false);
		if (sess != null) {
			System.out.println("invalidate");
			sess.invalidate();
		}
		resp.sendRedirect("./");
	}
}
