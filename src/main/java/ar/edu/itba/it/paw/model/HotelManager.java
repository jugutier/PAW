package ar.edu.itba.it.paw.model;

import java.util.List;

public class HotelManager {
	private static HotelManager instance;
	List<Hotel> hotels;

	private HotelManager() {
	}

	public static HotelManager getInstance() {
		if (instance == null) {
			instance = new HotelManager();
		}
		return instance;
	}

	public List<Hotel> getHotels() {
		if (hotels == null) {
			hotels = HotelGenerator.generate();
		}
		return hotels;
	}

	public Hotel getHotelByCode(int code) {
		for (Hotel h : hotels) {
			if (h.getCode() == code) {
				return h;
			}
		}
		return null;
	}

	public void setHotel(Hotel h) {
		System.out.println(hotels.size());
		hotels.remove(h);//Searches for code and removes old version
		System.out.println(hotels.size());
		hotels.add(h);//adds modified version
		System.out.println(hotels.size());
	}
}
