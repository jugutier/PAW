package ar.edu.itba.it.paw.view;

import ar.edu.itba.it.paw.model.Hotel;

public class HotelTableView {
	private HotelTableView() {

	}

	public static String getHeaderView() {
		return "<tr><th>Code</th><th>Name</th><th>Description</th></tr>";
	}
	public static String getTableView(Hotel h){
		String code = String.valueOf(h.getCode());
		String name = h.getName();
		String description = h.getDescription();

		return "<tr>" + makeTd(code)
				+ makeTd("<a href=/HotelApp/viewHotel/?code=" + code + ">" + name + "</a>")
				+ makeTd(description) + "</tr>";
	}
	public static String getDetailedView(Hotel h) {
		String code = String.valueOf(h.getCode());
		String name = h.getName();
		String description = h.getDescription();

		return "<tr>" + makeTd(code)
				+ makeTd( name )
				+ makeTd(description) + "</tr>";
	}

	private static String makeTd(String s) {
		return "<td>" + s + "</td>";

	}
}
