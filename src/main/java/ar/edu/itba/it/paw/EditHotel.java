package ar.edu.itba.it.paw;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.edu.itba.it.paw.model.Hotel;
import ar.edu.itba.it.paw.model.HotelManager;

@SuppressWarnings("serial")
public class EditHotel extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int requestedCode = Integer.valueOf(req.getParameter("code"));
		Hotel requestedHotel = HotelManager.getInstance().getHotelByCode(
				requestedCode);
		req.setAttribute("hotel", requestedHotel);
		req.getRequestDispatcher("/WEB-INF/jsp/editHotel.jsp").forward(req,
				resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int code = Integer.valueOf(req.getParameter("code"));
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		Hotel modified = new Hotel(code, name, description);
		HotelManager.getInstance().setHotel(modified);
		resp.sendRedirect("listHotels");
	}

}
